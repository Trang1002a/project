package com.example.project.controller;

import com.example.project.model.entity.Request;
import com.example.project.model.entity.Ticket;
import com.example.project.repository.RequestRepository;
import com.example.project.service.Impl.TicketServiceImpl;
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
@RequestMapping("admin/ticket")
public class TicketController {
    @Autowired
    private TicketServiceImpl ticketService;

    @Autowired
    private RequestRepository requestRepository;

    @GetMapping(value = {"", "/index"})
    public String index(Model model,
                        @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                        @RequestParam(value = "name", required = false, defaultValue = "") String name) {
        int size = 5;
        Pageable pageable = PageRequest.of(page-1, size);
        Page<Request> page_;
        if(name == null){
            page_ = requestRepository.findAll(pageable);
        } else {
            page_ = requestRepository.findByMovieContaining(name, pageable);
        }
        List<Request> list = page_.getContent();
        model.addAttribute(Layout.VIEW, list);
        model.addAttribute(Layout.CURRENT_PAGE, page_.getNumber());
        model.addAttribute(Layout.TOTAL_ITEMS, page_.getTotalElements());
        model.addAttribute(Layout.TOTAL_PAGES, page_.getTotalPages());
        model.addAttribute(Layout.PAGE, size);
        model.addAttribute(Layout.NAME, name);
        return Pages.ADMIN_TICKET_INDEX.uri();
    }
    @GetMapping("/insert")
    public String insert(Model model) {
        Ticket ticket = new Ticket();
        model.addAttribute("view", ticket);
        return Pages.ADMIN_TICKET_INSERT.uri();
    }
    @PostMapping("/insert")
    public String insert(Ticket ticket) {
        ticketService.save(ticket);
        return Pages.REDIRECT.uri() + Pages.ADMIN_TICKET_INDEX.uri();
    }
    @GetMapping("/edit")
    public String edit(@PathParam("id") int id, Model model) {
        Ticket ticket = ticketService.findById(id).get();
        model.addAttribute(Layout.VIEW, ticket);
        return Pages.ADMIN_TICKET_EDIT.uri();
    }
    @GetMapping("/delete")
    public String delete(@PathParam("id") int id, Model model) {
        ticketService.deleteById(id);
        return Pages.REDIRECT.uri() + Pages.ADMIN_TICKET_INDEX.uri();
    }
}
