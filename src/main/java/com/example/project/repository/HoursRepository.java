package com.example.project.repository;

import com.example.project.model.entity.Hours;
import com.example.project.model.entity.Ticket;
import com.example.project.model.entity.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoursRepository extends JpaRepository<Hours, Integer> {
    Page<Hours> findByNameContaining(String name, Pageable pageable);
}
