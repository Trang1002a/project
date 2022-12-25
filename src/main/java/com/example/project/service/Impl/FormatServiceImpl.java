package com.example.project.service.Impl;

import com.example.project.model.entity.Format;
import com.example.project.model.entity.Hours;
import com.example.project.model.entity.Type;
import com.example.project.repository.FormatRepository;
import com.example.project.repository.TypeRepository;
import com.example.project.service.FormatService;
import com.example.project.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormatServiceImpl implements FormatService {
    @Autowired
    private FormatRepository formatRepository;

    @Override
    public List<Format> findAll() {
        return formatRepository.findAll();
    }

    @Override
    public Page<Format> findAll(Pageable pageable) {
        return formatRepository.findAll(pageable);
    }

    @Override
    public Page<Format> findByNameContaining(String name, Pageable pageable) {
        return formatRepository.findByNameContaining(name, pageable);
    }

    @Override
    public Format save(Format format) {
        return formatRepository.save(format);
    }

    @Override
    public Optional<Format> findById(Integer id) {
        return formatRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        formatRepository.deleteById(id);
    }
}
