package com.example.project.service.Impl;

import com.example.project.model.entity.Movies;
import com.example.project.model.entity.Room;
import com.example.project.model.entity.Type;
import com.example.project.repository.MoviesRepository;
import com.example.project.repository.TypeRepository;
import com.example.project.service.MoviesService;
import com.example.project.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoviesServiceImpl implements MoviesService {
    @Autowired
    private MoviesRepository moviesRepository;

    @Override
    public List<Movies> findAll() {
        return moviesRepository.findAll();
    }

    @Override
    public Page<Movies> findAll(Pageable pageable) {
        return moviesRepository.findAll(pageable);
    }

    @Override
    public Page<Movies> findByNameContaining(String name, Pageable pageable) {
        return moviesRepository.findByNameContaining(name, pageable);
    }

    @Override
    public Movies save(Movies movies) {
        return moviesRepository.save(movies);
    }

    @Override
    public Optional<Movies> findById(Integer id) {
        return moviesRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        moviesRepository.deleteById(id);
    }
}
