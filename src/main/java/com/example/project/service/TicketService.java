package com.example.project.service;

import com.example.project.model.entity.Ticket;
import com.example.project.model.entity.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface TicketService {
    List<Ticket> findAll();
    Page<Ticket> findAll(Pageable pageable);
    Page<Ticket> findByNameContaining(String name ,Pageable pageable);
    Ticket save(Ticket ticket);
    Optional<Ticket> findById(Integer id);
    void deleteById(Integer id);
}
