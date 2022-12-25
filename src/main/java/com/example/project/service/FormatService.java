package com.example.project.service;

import com.example.project.model.entity.Format;
import com.example.project.model.entity.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface FormatService {
    List<Format> findAll();
    Page<Format> findAll(Pageable pageable);
    Page<Format> findByNameContaining(String name ,Pageable pageable);
    Format save(Format format);
    Optional<Format> findById(Integer id);
    void deleteById(Integer id);
}
