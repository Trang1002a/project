package com.example.project.repository;

import com.example.project.model.entity.Room;
import com.example.project.model.entity.Ticket;
import com.example.project.model.entity.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
    Page<Room> findByNameContaining(String name, Pageable pageable);
    List<Room> findByIdInAndStatus(List<Integer> ids, boolean status);
    Room findByIdAndStatus(Integer id, boolean status);
    List<Room> findAllByStatus(boolean status);
//    List<Room> findByBranch_idIn(List<Integer> branchId);
    @Query("SELECT r FROM Room r WHERE r.branch_id = :branch_id and r.status = true")
    List<Room> findByBranch_id(@Param("branch_id") Integer branch_id);

    @Transactional
    @Modifying
    @Query("update Room r SET  r.status = :status WHERE r.branch_id = :branch_id")
    void updateStatusRoom(@Param("status") boolean status, @Param("branch_id") Integer branch_id);
}