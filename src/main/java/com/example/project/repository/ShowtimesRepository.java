package com.example.project.repository;

import com.example.project.model.entity.Showtimes;
import com.example.project.model.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowtimesRepository extends JpaRepository<Showtimes, Integer> {
}
