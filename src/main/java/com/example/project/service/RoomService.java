package com.example.project.service;

import com.example.project.model.entity.Room;
import com.example.project.model.entity.Type;

import java.util.List;
import java.util.Optional;

public interface RoomService {
    List<Room> findAll();
    Room save(Room room);
    Optional<Room> findById(Integer id);
    void deleteById(Integer id);
}
