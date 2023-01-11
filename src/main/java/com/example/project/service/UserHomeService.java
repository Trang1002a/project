package com.example.project.service;

import com.example.project.model.dto.BookTicketDTO;
import com.example.project.model.dto.MoviesDetailDTO;
import com.example.project.model.dto.MoviesShowDTO;
import com.example.project.model.dto.RoomDTO;
import com.example.project.model.entity.Branch;
import com.example.project.model.entity.Request;
import com.example.project.model.entity.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserHomeService {
    List<MoviesShowDTO> getHomeMovie();
    MoviesDetailDTO getDetail(Integer id);
    BookTicketDTO getBookTicket(Integer id, String hour);
    Request saveRequest(Request request);
    List<String> getSlot(String ticket_id);
    List<Request> search(String phone_number, String ticked_id);
}
