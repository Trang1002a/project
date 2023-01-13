package com.example.project.repository;

import com.example.project.model.entity.Request;
import com.example.project.model.entity.Showtimes;
import com.example.project.model.entity.Ticket;
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
public interface RequestRepository extends JpaRepository<Request, Integer> {
    @Transactional
    @Modifying
    @Query("select r from Request r WHERE r.ticket_id = :ticket_id AND r.status = :status")
    List<Request> findAllByTicket_id(@Param("ticket_id") String ticket_id, @Param("status") boolean status);

    @Transactional
    @Modifying
    @Query("select r from Request r WHERE r.id = :id AND r.phoneNumber = :phoneNumber")
    List<Request> findByIdInAndPhoneNumberIn(@Param("id") Integer id, @Param("phoneNumber") String phoneNumber);

    Page<Request> findByMovieContaining(String name, Pageable pageable);
}
