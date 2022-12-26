package com.example.project.util.mapper;

import com.example.project.model.dto.BranchDTO;
import com.example.project.model.dto.RoomDTO;
import com.example.project.model.entity.Branch;
import com.example.project.model.entity.Room;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class BranchMapper {
    public List<BranchDTO> mapListBranchDTO(List<Branch> listBranch, List<Room> listRoom){
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
            List<RoomDTO> dtoList = new ArrayList<>();
            if (!StringUtils.isEmpty(list.getRoom_id())){
                List<String> room_id = Arrays.asList(list.getRoom_id().split(","));
                if (room_id.size() > 0){
                    listRoom.forEach(l ->{
                        if (room_id.contains(String.valueOf(l.getId()))){
                            RoomDTO roomDTO = new RoomDTO();
                            roomDTO.setId(l.getId());
                            roomDTO.setName(l.getName());
                            roomDTO.setTotal(l.getTotal());
                            dtoList.add(roomDTO);
                        }
                    });
                }
            }
            branchDTO.setRoom(dtoList);
            branchDTOList.add(branchDTO);
        });
        return branchDTOList;
    }
}
