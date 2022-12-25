package com.example.project.service.Impl;

import com.example.project.model.entity.Branch;
import com.example.project.model.entity.Country;
import com.example.project.model.entity.Type;
import com.example.project.repository.BranchRepository;
import com.example.project.repository.TypeRepository;
import com.example.project.service.BranchService;
import com.example.project.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BranchServiceImpl implements BranchService {
    @Autowired
    private BranchRepository branchRepository;

    @Override
    public List<Branch> findAll() {
        return branchRepository.findAll();
    }

    @Override
    public Page<Branch> findAll(Pageable pageable) {
        return branchRepository.findAll(pageable);
    }

    @Override
    public Page<Branch> findByNameContaining(String name, Pageable pageable) {
        return branchRepository.findByNameContaining(name, pageable);
    }

    @Override
    public Branch save(Branch branch) {
        return branchRepository.save(branch);
    }

    @Override
    public Optional<Branch> findById(Integer id) {
        return branchRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        branchRepository.deleteById(id);
    }
}
