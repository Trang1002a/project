package com.example.project.service.Impl;

import com.example.project.model.entity.Showtimes;
import com.example.project.model.entity.Ticket;
import com.example.project.model.entity.Type;
import com.example.project.repository.ShowtimesRepository;
import com.example.project.repository.TypeRepository;
import com.example.project.service.ShowtimesService;
import com.example.project.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShowtimesServiceImpl implements ShowtimesService {
    @Autowired
    private ShowtimesRepository showtimesRepository;

    @Override
    public List<Showtimes> findAll() {
        return showtimesRepository.findAll();
    }

    @Override
    public Page<Showtimes> findAll(Pageable pageable) {
        return showtimesRepository.findAll(pageable);
    }

    @Override
    public Page<Showtimes> findByNameContaining(String name, Pageable pageable) {
        return showtimesRepository.findByNameContaining(name, pageable);
    }
    @Override
    public Showtimes save(Showtimes showtimes) {
        return showtimesRepository.save(showtimes);
    }

    @Override
    public Optional<Showtimes> findById(Integer id) {
        return showtimesRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        showtimesRepository.deleteById(id);
    }
}
