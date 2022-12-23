package com.example.project.service;

import com.example.project.model.entity.Showtimes;
import com.example.project.model.entity.Type;

import java.util.List;
import java.util.Optional;

public interface ShowtimesService {
    List<Showtimes> findAll();
    Showtimes save(Showtimes showtimes);
    Optional<Showtimes> findById(Integer id);
    void deleteById(Integer id);
}
