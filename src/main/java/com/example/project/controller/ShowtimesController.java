package com.example.project.controller;

import com.example.project.model.dto.MoviesDTO;
import com.example.project.model.dto.ShowtimesDTO;
import com.example.project.model.entity.*;
import com.example.project.service.Impl.*;
import com.example.project.util.Pages;
import com.example.project.util.mapper.ShowtimesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import com.example.project.util.Layout;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.websocket.server.PathParam;

@Controller
@RequestMapping("admin/showtimes")
public class ShowtimesController {
    @Autowired
    private ShowtimesServiceImpl showtimesService;

    @Autowired
    private MoviesServiceImpl moviesService;

    @Autowired
    private BranchServiceImpl branchService;

    @Autowired
    private RoomServiceImpl roomService;

    @Autowired
    private HoursServiceImpl hoursService;

    private final ShowtimesMapper showtimesMapper = new ShowtimesMapper();

    @GetMapping(value = {"", "/index"})
    public String index(Model model,
                        @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                        @RequestParam(value = "name", required = false, defaultValue = "") String name) {
        int size = 5;
        Pageable pageable = PageRequest.of(page-1, size);
        Page<Showtimes> page_;
        if(name == null){
            page_ = showtimesService.findAll(pageable);
        } else {
            page_ = showtimesService.findByNameContaining(name, pageable);
        }
        List<Showtimes> showtimes = showtimesService.findAll();
        List<Movies> movies = moviesService.findAll();
        List<Branch> branches = branchService.findAll();
        List<Room> rooms = roomService.findAll();
        List<Hours> hours = hoursService.findAll();
        List<ShowtimesDTO> list = showtimesMapper.mapShowtimesDTO(showtimes, movies, branches, rooms, hours);
        model.addAttribute(Layout.VIEW, list);
        model.addAttribute(Layout.CURRENT_PAGE, page_.getNumber());
        model.addAttribute(Layout.TOTAL_ITEMS, page_.getTotalElements());
        model.addAttribute(Layout.TOTAL_PAGES, page_.getTotalPages());
        model.addAttribute(Layout.PAGE, size);
        model.addAttribute(Layout.NAME, name);
        return Pages.ADMIN_SHOWTIMES_INDEX.uri();
    }
    @GetMapping("/insert")
    public String insert(Model model) {
        Showtimes showtimes = new Showtimes();
        List<Movies> movies = moviesService.findAll();
        List<Branch> branch = branchService.findAll();
        List<Room> room = roomService.findAll();
        List<Hours> hours = hoursService.findAll();
        model.addAttribute(Layout.MOVIES, movies);
        model.addAttribute(Layout.BRANCH, branch);
        model.addAttribute(Layout.ROOM, room);
        model.addAttribute(Layout.HOURS, hours);
        model.addAttribute(Layout.VIEW, showtimes);
        return Pages.ADMIN_SHOWTIMES_INSERT.uri();
    }
    @PostMapping("/insert")
    public String insert(Showtimes showtimes) {
        showtimesService.save(showtimes);
        return Pages.REDIRECT.uri() + Pages.ADMIN_SHOWTIMES_INDEX.uri();
    }
    @GetMapping("/edit")
    public String edit(@PathParam("id") int id, Model model) {
        Showtimes showtimes = showtimesService.findById(id).get();
        List<Movies> movies = moviesService.findAll();
        List<Branch> branch = branchService.findAll();
        List<Room> room = roomService.findAll();
        List<Hours> hours = hoursService.findAll();
        model.addAttribute(Layout.MOVIES, movies);
        model.addAttribute(Layout.BRANCH, branch);
        model.addAttribute(Layout.ROOM, room);
        model.addAttribute(Layout.HOURS, hours);
        model.addAttribute(Layout.VIEW, showtimes);
        return Pages.ADMIN_SHOWTIMES_EDIT.uri();
    }
    @GetMapping("/delete")
    public String delete(@PathParam("id") int id, Model model) {
        showtimesService.deleteById(id);
        return Pages.REDIRECT.uri() + Pages.ADMIN_SHOWTIMES_INDEX.uri();
    }
    @GetMapping("/json-data")
    @ResponseBody
    public ResponseEntity<?> getJson(@PathParam("room_id") int room_id) {
        Optional<Branch> branch = branchService.findById(room_id);
        List<String> room_id1 = Arrays.asList(branch.get().getRoom_id().split(","));
        List<Integer> room_idd = room_id1.stream().map(Integer::parseInt).collect(Collectors.toList());
        List<Room> room = roomService.findByIdIn(room_idd);
        return new ResponseEntity<>(room, HttpStatus.OK);
    }
}
