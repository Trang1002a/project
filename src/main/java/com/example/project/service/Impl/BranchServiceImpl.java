package com.example.project.service.Impl;

import com.example.project.model.entity.Branch;
import com.example.project.model.entity.Type;
import com.example.project.repository.BranchRepository;
import com.example.project.repository.TypeRepository;
import com.example.project.service.BranchService;
import com.example.project.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
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
