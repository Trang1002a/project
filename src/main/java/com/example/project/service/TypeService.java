package com.example.project.service;

import com.example.project.model.entity.Type;

import java.util.List;
import java.util.Optional;

public interface TypeService {
    List<Type> findAll();
    Type save(Type type);
    Optional<Type> findById(Integer id);
    void deleteById(Integer id);
}
