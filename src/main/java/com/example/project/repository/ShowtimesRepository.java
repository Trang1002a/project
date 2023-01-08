package com.example.project.repository;

import com.example.project.model.dto.MoviesIDAndDay;
import com.example.project.model.entity.Showtimes;
import com.example.project.model.entity.Ticket;
import com.example.project.model.entity.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ShowtimesRepository extends JpaRepository<Showtimes, Integer> {
    Page<Showtimes> findByNameContaining(String name, Pageable pageable);

    @Transactional
    @Modifying
    @Query("select new com.example.project.model.dto.MoviesIDAndDay(t.movies_id, MIN(t.movie_day)) from Showtimes t WHERE t.status = :status GROUP BY t.movies_id")
    List<MoviesIDAndDay> findAllByStatus(@Param("status") boolean status);

    @Transactional
    @Modifying
    @Query("select t from Showtimes t WHERE t.movies_id = :id AND t.status = :status ORDER BY t.movie_day ASC ")
    List<Showtimes> findAllByIdAndStatusOrderByMovie_dayAsc(@Param("id") String id, @Param("status") boolean status);
}
