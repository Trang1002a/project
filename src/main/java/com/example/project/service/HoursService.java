package com.example.project.service;

import com.example.project.model.entity.Hours;
import com.example.project.model.entity.Type;

import java.util.List;
import java.util.Optional;

public interface HoursService {
    List<Hours> findAll();
    Hours save(Hours hours);
    Optional<Hours> findById(Integer id);
    void deleteById(Integer id);
}
