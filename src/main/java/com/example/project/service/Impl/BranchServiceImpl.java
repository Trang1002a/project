package com.example.project.service.Impl;

import com.example.project.model.dto.RoomDTO;
import com.example.project.model.entity.Branch;
import com.example.project.model.entity.Country;
import com.example.project.model.entity.Room;
import com.example.project.model.entity.Type;
import com.example.project.repository.BranchRepository;
import com.example.project.repository.TypeRepository;
import com.example.project.service.BranchService;
import com.example.project.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BranchServiceImpl implements BranchService {
    @Autowired
    private BranchRepository branchRepository;

    @Override
    public List<Branch> findAll() {
        return branchRepository.findAll();
    }

    @Override
    public Page<Branch> findAll(Pageable pageable) {
        return branchRepository.findAll(pageable);
    }

    @Override
    public Page<Branch> findByNameContaining(String name, Pageable pageable) {
        return branchRepository.findByNameContaining(name, pageable);
    }

    @Override
    public Branch save(Branch branch) {
        return branchRepository.save(branch);
    }

    @Override
    public Optional<Branch> findById(Integer id) {
        return branchRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        branchRepository.deleteById(id);
    }

    @Override
    public List<Room> getListRoom(Integer branchId, List<RoomDTO> list) {
//        List<Room> rooms = new ArrayList<>();
//        list.stream().filter(roomDTO -> (!StringUtils.isEmpty(roomDTO.getName()) &&
//                !StringUtils.isEmpty(roomDTO.getRow()) && !StringUtils.isEmpty(roomDTO.getCol())))
//                .peek(roomDTO -> {
//                    Room room = new Room();
//                    room.setBranch_id(branchId);
//                    room.setName(roomDTO.getName());
//                    room.setCol(roomDTO.getCol());
//                    room.setRow(roomDTO.getCol());
//                    room.setTotal(String.valueOf(Integer.parseInt(roomDTO.getRow()) * Integer.parseInt(roomDTO.getCol())));
//                    room.setStatus(roomDTO.isStatus());
//                    rooms.add(room);
//                });
//        return rooms;

        List<Room> rooms = new ArrayList<>();
        List<RoomDTO> roomDTOS = list.stream().filter(roomDTO -> (!StringUtils.isEmpty(roomDTO.getName()) &&
                !StringUtils.isEmpty(roomDTO.getRow()) && !StringUtils.isEmpty(roomDTO.getCol())))
                .collect(Collectors.toList());
        roomDTOS.forEach(roomDTO -> {
            Room room = new Room();
            room.setBranch_id(branchId);
            room.setName(roomDTO.getName());
            room.setCol(roomDTO.getCol());
            room.setRow(roomDTO.getCol());
            room.setTotal(String.valueOf(Integer.parseInt(roomDTO.getRow()) * Integer.parseInt(roomDTO.getCol())));
            room.setStatus(roomDTO.isStatus());
            rooms.add(room);
        });
        return rooms;
    }
}
