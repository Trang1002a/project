package com.example.project.service;

import com.example.project.model.entity.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface TypeService {
    List<Type> findAll();
    Page<Type> findAll(Pageable pageable);
    Page<Type> findByNameContaining(String name ,Pageable pageable);
    Type save(Type type);
    Optional<Type> findById(Integer id);
    void deleteById(Integer id);
}
