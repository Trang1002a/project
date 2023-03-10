package com.example.project.service.Impl;

import com.example.project.model.entity.Hours;
import com.example.project.model.entity.Movies;
import com.example.project.model.entity.Type;
import com.example.project.repository.HoursRepository;
import com.example.project.repository.TypeRepository;
import com.example.project.service.HoursService;
import com.example.project.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HoursServiceImpl implements HoursService {
    @Autowired
    private HoursRepository hoursRepository;

    @Override
    public List<Hours> findAll() {
        return hoursRepository.findAll();
    }

    @Override
    public Page<Hours> findAll(Pageable pageable) {
        return hoursRepository.findAll(pageable);
    }

    @Override
    public Page<Hours> findByNameContaining(String name, Pageable pageable) {
        return hoursRepository.findByNameContaining(name, pageable);
    }

    @Override
    public Hours save(Hours hours) {
        return hoursRepository.save(hours);
    }

    @Override
    public Optional<Hours> findById(Integer id) {
        return hoursRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        hoursRepository.deleteById(id);
    }
}
