package com.example.project.util.mapper;

import com.example.project.model.dto.BranchDTO;
import com.example.project.model.dto.RoomDTO;
import com.example.project.model.entity.Branch;
import com.example.project.model.entity.Room;
import com.example.project.repository.RoomRepository;
import com.example.project.service.Impl.BranchServiceImpl;
import com.example.project.service.Impl.RoomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BranchMapper {
    @Autowired
    private BranchServiceImpl branchService;
    @Autowired
    private RoomServiceImpl roomService;

    @Autowired
    private RoomRepository roomRepository;

    public List<BranchDTO> mapListBranchDTO(List<Branch> listBranch){
        List<Room> listRoom = roomRepository.findAllByStatus(true);
        List<BranchDTO> branchDTOList = new ArrayList<>();
        listBranch.forEach(list ->{
            BranchDTO branchDTO = new BranchDTO();
            branchDTO.setId(list.getId());
            branchDTO.setName(list.getName());
            branchDTO.setPhone_number(list.getPhone_number());
            branchDTO.setAddress(list.getAddress());
            branchDTO.setShort_name(list.getShort_name());
            branchDTO.setTotal(list.getTotal());
            branchDTO.setStatus(list.isStatus());
//            List<RoomDTO> dtoList = new ArrayList<>();
//            if (!StringUtils.isEmpty(list.getRoom_id())){
//                List<String> room_id = Arrays.asList(list.getRoom_id().split(","));
//                if (room_id.size() > 0){
//                    listRoom.forEach(l ->{
//                        if (room_id.contains(String.valueOf(l.getId()))){
//                            RoomDTO roomDTO = new RoomDTO();
//                            roomDTO.setId(l.getId());
//                            roomDTO.setName(l.getName());
//                            roomDTO.setTotal(l.getTotal());
//                            dtoList.add(roomDTO);
//                        }
//                    });
//                }
//            }
            List<RoomDTO> roomDTOList = new ArrayList<>();
            List<Room> dtoList = listRoom.stream().filter(room -> room.getBranch_id() == list.getId())
                    .collect(Collectors.toList());
            dtoList.forEach(roomDTO -> {
                RoomDTO room = new RoomDTO();
                room.setName(roomDTO.getName());
                room.setCol(roomDTO.getCol());
                room.setRow(roomDTO.getCol());
                room.setTotal(String.valueOf(Integer.parseInt(roomDTO.getRow()) * Integer.parseInt(roomDTO.getCol())));
                room.setStatus(roomDTO.isStatus());
                roomDTOList.add(room);
            });
            branchDTO.setRoom(roomDTOList);
            branchDTOList.add(branchDTO);
        });
        return branchDTOList;
    }

    public Branch mapToBranch(BranchDTO branchDTO){
        Branch branch = new Branch();
        branch.setId(branchDTO.getId());
        branch.setName(branchDTO.getName());
        branch.setPhone_number(branchDTO.getPhone_number());
        branch.setAddress(branchDTO.getAddress());
        branch.setShort_name(branchDTO.getShort_name());
        branch.setStatus(branchDTO.isStatus());
        branch.setCreated_at(branchDTO.getCreated_at());

        List<RoomDTO> roomDTOS = branchDTO.getRoom().stream().filter(roomDTO -> (!StringUtils.isEmpty(roomDTO.getName()) &&
                !StringUtils.isEmpty(roomDTO.getRow()) && !StringUtils.isEmpty(roomDTO.getCol())))
                .collect(Collectors.toList());
        branch.setTotal(String.valueOf(roomDTOS.size()));
        branchService.save(branch);

        roomRepository.updateStatusRoom(false, branchDTO.getId());
        List<Room> rooms = new ArrayList<>();
        roomDTOS.forEach(roomDTO -> {
            Room room = new Room();
            room.setId(roomDTO.getId());
            room.setBranch_id(branch.getId());
            room.setName(roomDTO.getName());
            room.setCol(roomDTO.getCol());
            room.setRow(roomDTO.getRow());
            room.setTotal(String.valueOf(Integer.parseInt(roomDTO.getRow()) * Integer.parseInt(roomDTO.getCol())));
            room.setStatus(true);
            rooms.add(room);
        });
        roomService.saveAll(rooms);
        return branch;
    }
}
