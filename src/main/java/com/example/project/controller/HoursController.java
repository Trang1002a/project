package com.example.project.controller;

import com.example.project.model.entity.Hours;
import com.example.project.service.Impl.HoursServiceImpl;
import com.example.project.util.Pages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import com.example.project.util.Layout;
import java.util.List;

import javax.websocket.server.PathParam;

@Controller
@RequestMapping("admin/hours")
public class HoursController {
    @Autowired
    private HoursServiceImpl hoursService;

    @GetMapping(value = {"", "/index"})
    public String index(Model model,
                        @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                        @RequestParam(value = "name", required = false, defaultValue = "") String name) {
        int size = 5;
        Pageable pageable = PageRequest.of(page-1, size);
        Page<Hours> page_;
        if(name == null){
            page_ = hoursService.findAll(pageable);
        } else {
            page_ = hoursService.findByNameContaining(name, pageable);
        }
        List<Hours> list = page_.getContent();
        model.addAttribute(Layout.VIEW, list);
        model.addAttribute(Layout.CURRENT_PAGE, page_.getNumber());
        model.addAttribute(Layout.TOTAL_ITEMS, page_.getTotalElements());
        model.addAttribute(Layout.TOTAL_PAGES, page_.getTotalPages());
        model.addAttribute(Layout.PAGE, size);
        model.addAttribute(Layout.NAME, name);
        return Pages.ADMIN_HOURS_INDEX.uri();
    }
    @GetMapping("/insert")
    public String insert(Model model) {
        Hours hours = new Hours();
        model.addAttribute("view", hours);
        return Pages.ADMIN_HOURS_INSERT.uri();
    }
    @PostMapping("/insert")
    public String insert(Hours hours) {
        hoursService.save(hours);
        return Pages.REDIRECT.uri() + Pages.ADMIN_HOURS_INDEX.uri();
    }
    @GetMapping("/edit")
    public String edit(@PathParam("id") int id, Model model) {
        Hours hours = hoursService.findById(id).get();
        model.addAttribute(Layout.VIEW, hours);
        return Pages.ADMIN_HOURS_EDIT.uri();
    }
    @GetMapping("/delete")
    public String delete(@PathParam("id") int id, Model model) {
        hoursService.deleteById(id);
        return Pages.REDIRECT.uri() + Pages.ADMIN_HOURS_INDEX.uri();
    }
}
