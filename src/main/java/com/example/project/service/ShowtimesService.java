package com.example.project.service;

import com.example.project.model.entity.Showtimes;
import com.example.project.model.entity.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ShowtimesService {
    List<Showtimes> findAll();
    Page<Showtimes> findAll(Pageable pageable);
    Page<Showtimes> findByNameContaining(String name ,Pageable pageable);
    Showtimes save(Showtimes showtimes);
    Optional<Showtimes> findById(Integer id);
    void deleteById(Integer id);
}
