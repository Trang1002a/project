package com.example.project.service;

import com.example.project.model.entity.Country;
import com.example.project.model.entity.Type;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> findAll();
    Country save(Country country);
    Optional<Country> findById(Integer id);
    void deleteById(Integer id);
}
