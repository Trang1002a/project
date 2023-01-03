package com.example.project.service;

import com.example.project.model.entity.Room;
import com.example.project.model.entity.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface RoomService {
    List<Room> findAll();
    Page<Room> findAll(Pageable pageable);
    Page<Room> findByNameContaining(String name ,Pageable pageable);
    Room save(Room room);
    Optional<Room> findById(Integer id);
    void deleteById(Integer id);
    List<Room> findByIdIn(List<Integer> id);
}
