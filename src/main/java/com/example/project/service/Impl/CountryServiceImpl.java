package com.example.project.service.Impl;

import com.example.project.model.entity.Country;
import com.example.project.model.entity.Format;
import com.example.project.model.entity.Type;
import com.example.project.repository.CountryRepository;
import com.example.project.repository.TypeRepository;
import com.example.project.service.CountryService;
import com.example.project.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Page<Country> findAll(Pageable pageable) {
        return countryRepository.findAll(pageable);
    }

    @Override
    public Page<Country> findByNameContaining(String name, Pageable pageable) {
        return countryRepository.findByNameContaining(name, pageable);
    }

    @Override
    public Country save(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Optional<Country> findById(Integer id) {
        return countryRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        countryRepository.deleteById(id);
    }
}
