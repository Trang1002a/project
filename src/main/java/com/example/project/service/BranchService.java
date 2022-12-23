package com.example.project.service;

import com.example.project.model.entity.Branch;

import java.util.List;
import java.util.Optional;

public interface BranchService {
    List<Branch> findAll();
    Branch save(Branch branch);
    Optional<Branch> findById(Integer id);
    void deleteById(Integer id);
}
