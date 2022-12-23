package com.example.project.service;

import com.example.project.model.entity.Ticket;
import com.example.project.model.entity.Type;

import java.util.List;
import java.util.Optional;

public interface TicketService {
    List<Ticket> findAll();
    Ticket save(Ticket ticket);
    Optional<Ticket> findById(Integer id);
    void deleteById(Integer id);
}
