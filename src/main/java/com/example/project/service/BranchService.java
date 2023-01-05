package com.example.project.service;

import com.example.project.model.dto.RoomDTO;
import com.example.project.model.entity.Branch;
import com.example.project.model.entity.Room;
import com.example.project.model.entity.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BranchService {
    List<Branch> findAll();
    Page<Branch> findAll(Pageable pageable);
    Page<Branch> findByNameContaining(String name ,Pageable pageable);
    Branch save(Branch branch);
    Optional<Branch> findById(Integer id);
    void deleteById(Integer id);
    List<Room> getListRoom(Integer branchId, List<RoomDTO> list);
}
