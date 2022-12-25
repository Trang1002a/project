package com.example.project.service;

import com.example.project.model.entity.Hours;
import com.example.project.model.entity.Movies;
import com.example.project.model.entity.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface MoviesService {
    List<Movies> findAll();
    Page<Movies> findAll(Pageable pageable);
    Page<Movies> findByNameContaining(String name ,Pageable pageable);
    Movies save(Movies movies);
    Optional<Movies> findById(Integer id);
    void deleteById(Integer id);
}
