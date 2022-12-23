package com.example.project.service;

import com.example.project.model.entity.Format;
import com.example.project.model.entity.Type;

import java.util.List;
import java.util.Optional;

public interface FormatService {
    List<Format> findAll();
    Format save(Format format);
    Optional<Format> findById(Integer id);
    void deleteById(Integer id);
}
