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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        List<MoviesShowDTO> list =  userHomeService.getHomeMovie(null);
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
    public String insert(Request request, Model model) {
        Request req = userHomeService.saveRequest(request);
        model.addAttribute(Layout.VIEW, req);
        return Pages.MOVIE_BOOK_SUCCESS.uri();
    }

    @GetMapping(value = { "/search"})
    public String search(Model model,
                         @RequestParam(value = "phone_number", required = false, defaultValue = "") String phone_number,
                         @RequestParam(value = "ticket_id", required = false, defaultValue = "") String ticket_id) {
        List<Request> list = userHomeService.search(phone_number, ticket_id);
        model.addAttribute(Layout.VIEW, list);
        return Pages.MOVIE_SEARCH.uri();
    }

    @GetMapping("/allMovie")
    public String allMovie(Model model,
                           @RequestParam(value = "name", required = false, defaultValue = "") String name) {
        List<MoviesShowDTO> list =  userHomeService.getHomeMovie(name);
        model.addAttribute(Layout.VIEW, list);
        return Pages.ALL_MOVIE.uri();
    }
}
