package com.example.project.service;

import com.example.project.model.entity.Hours;
import com.example.project.model.entity.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface HoursService {
    List<Hours> findAll();
    Page<Hours> findAll(Pageable pageable);
    Page<Hours> findByNameContaining(String name ,Pageable pageable);
    Hours save(Hours hours);
    Optional<Hours> findById(Integer id);
    void deleteById(Integer id);
}
