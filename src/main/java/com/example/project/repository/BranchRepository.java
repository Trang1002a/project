package com.example.project.repository;

import com.example.project.model.entity.Branch;
import com.example.project.model.entity.Ticket;
import com.example.project.model.entity.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Integer> {
    Page<Branch> findByNameContaining(String name, Pageable pageable);

    List<Branch> findByIdIn(List<Integer> branch_id);
}
