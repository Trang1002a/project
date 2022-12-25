package com.example.project.service;

import com.example.project.model.entity.Country;
import com.example.project.model.entity.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> findAll();
    Page<Country> findAll(Pageable pageable);
    Page<Country> findByNameContaining(String name ,Pageable pageable);
    Country save(Country country);
    Optional<Country> findById(Integer id);
    void deleteById(Integer id);
}
