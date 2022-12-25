package com.example.project.service.Impl;

import com.example.project.model.entity.Type;
import com.example.project.repository.TypeRepository;
import com.example.project.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeRepository typeRepository;

    @Override
    public List<Type> findAll() {
        return typeRepository.findAll();
    }

    @Override
    public Page<Type> findAll(Pageable pageable) {
        return typeRepository.findAll(pageable);
    }

    @Override
    public Page<Type> findByNameContaining(String name, Pageable pageable) {
        return typeRepository.findByNameContaining(name, pageable);
    }

    @Override
    public Type save(Type type) {
        return typeRepository.save(type);
    }

    @Override
    public Optional<Type> findById(Integer id) {
        return typeRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        typeRepository.deleteById(id);
    }
}
