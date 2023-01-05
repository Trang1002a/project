package com.example.project.repository;

import com.example.project.model.entity.Room;
import com.example.project.model.entity.Ticket;
import com.example.project.model.entity.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
    Page<Room> findByNameContaining(String name, Pageable pageable);
    List<Room> findByIdIn(List<Integer> ids);
    List<Room> findByBranch_idIn(List<Integer> branchId);
    @Query("SELECT r FROM Room r WHERE r.branch_id = :branchId")
    List<Room> findByBranch_id(@Param("branchId") Integer branchId);
}