package com.example.project.service.Impl;

import com.example.project.model.entity.Room;
import com.example.project.model.entity.Showtimes;
import com.example.project.model.entity.Type;
import com.example.project.repository.RoomRepository;
import com.example.project.repository.TypeRepository;
import com.example.project.service.RoomService;
import com.example.project.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomRepository roomRepository;

    @Override
    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    @Override
    public Page<Room> findAll(Pageable pageable) {
        return roomRepository.findAll(pageable);
    }

    @Override
    public Page<Room> findByNameContaining(String name, Pageable pageable) {
        return roomRepository.findByNameContaining(name, pageable);
    }

    @Override
    public Room save(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public Optional<Room> findById(Integer id) {
        return roomRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        roomRepository.deleteById(id);
    }

    @Override
    public List<Room> findByIdIn(List<Integer> ids) {
        return roomRepository.findByIdInAndStatus(ids, true
        );

    }

    @Override
    public List<Room> saveAll(List<Room> rooms) {
        return roomRepository.saveAll(rooms);
    }

    @Override
    public List<Room> findByBranch_idIn(Integer branchId) {
        return roomRepository.findByBranch_id(branchId);
//        return null;
    }

}
