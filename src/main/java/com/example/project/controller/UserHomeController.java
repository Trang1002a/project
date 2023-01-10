package com.example.project.controller;

import com.example.project.model.dto.BookTicketDTO;
import com.example.project.model.dto.MoviesDetailDTO;
import com.example.project.model.dto.MoviesShowDTO;
import com.example.project.model.entity.*;
import com.example.project.repository.RequestRepository;
import com.example.project.service.Impl.UserHomeServiceImpl;
import com.example.project.util.Layout;
import com.example.project.util.Pages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
@RequestMapping("/movie")
public class UserHomeController {
    @Autowired
    private UserHomeServiceImpl userHomeService;

    @Autowired
    private RequestRepository requestRepository;

    @GetMapping(value = {"", "/index"})
    public String index(Model model) {
        List<MoviesShowDTO> list =  userHomeService.getHomeMovie();
//        List<Type> list = typeService.getList();
        model.addAttribute(Layout.VIEW, list);
        return Pages.USER_HOME_INDEX.uri();
    }

    @GetMapping("/detail")
    public String detail(@PathParam("id") int id, Model model) {
        MoviesDetailDTO moviesDetailDTO = userHomeService.getDetail(id);
        model.addAttribute(Layout.VIEW, moviesDetailDTO);
        return Pages.MOVIE_DETAIL.uri();
    }

    @GetMapping("/bookTicket")
    public String bookTicket(@PathParam("id") int id, @PathParam("hour") String hour, Model model) {
        BookTicketDTO bookTicketDTO = userHomeService.getBookTicket(id, hour);
        Request request = new Request();
        model.addAttribute(Layout.VIEW, bookTicketDTO);
        model.addAttribute(Layout.REQUEST, request);
        return Pages.MOVIE_BOOK_TICKET.uri();
    }

    @PostMapping("/book")
    public String insert(Request request) {
        Request req = userHomeService.saveRequest(request);
        return Pages.REDIRECT.uri() + Pages.ADMIN_HOURS_INDEX.uri();
    }
}
