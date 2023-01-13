package com.example.project.repository;

import com.example.project.model.entity.Movies;
import com.example.project.model.entity.Ticket;
import com.example.project.model.entity.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoviesRepository extends JpaRepository<Movies, Integer> {
    Page<Movies> findByNameContaining(String name, Pageable pageable);

    List<Movies> findAllByIdIn(List<Integer> ids);

    List<Movies> findAllByIdInAndNameContaining(List<Integer> ids, String name);
}
