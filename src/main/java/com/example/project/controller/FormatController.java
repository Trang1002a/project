package com.example.project.controller;

import com.example.project.model.entity.Format;
import com.example.project.service.Impl.FormatServiceImpl;
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
@RequestMapping("admin/format")
public class FormatController {
    @Autowired
    private FormatServiceImpl formatService;

    @GetMapping(value = {"", "/index"})
    public String index(Model model,
                        @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                        @RequestParam(value = "name", required = false, defaultValue = "") String name) {
        int size = 5;
        Pageable pageable = PageRequest.of(page-1, size);
        Page<Format> page_;
        if(name == null){
            page_ = formatService.findAll(pageable);
        } else {
            page_ = formatService.findByNameContaining(name, pageable);
        }
        List<Format> list = page_.getContent();
        model.addAttribute(Layout.VIEW, list);
        model.addAttribute(Layout.CURRENT_PAGE, page_.getNumber());
        model.addAttribute(Layout.TOTAL_ITEMS, page_.getTotalElements());
        model.addAttribute(Layout.TOTAL_PAGES, page_.getTotalPages());
        model.addAttribute(Layout.PAGE, size);
        model.addAttribute(Layout.NAME, name);
        return Pages.ADMIN_FORMAT_INDEX.uri();
    }
    @GetMapping("/insert")
    public String insert(Model model) {
        Format format = new Format();
        model.addAttribute("view", format);
        return Pages.ADMIN_FORMAT_INSERT.uri();
    }
    @PostMapping("/insert")
    public String insert(Format format) {
        formatService.save(format);
        return Pages.REDIRECT.uri() + Pages.ADMIN_FORMAT_INDEX.uri();
    }
    @GetMapping("/edit")
    public String edit(@PathParam("id") int id, Model model) {
        Format format = formatService.findById(id).get();
        model.addAttribute(Layout.VIEW, format);
        return Pages.ADMIN_FORMAT_EDIT.uri();
    }
    @GetMapping("/delete")
    public String delete(@PathParam("id") int id, Model model) {
        formatService.deleteById(id);
        return Pages.REDIRECT.uri() + Pages.ADMIN_FORMAT_INDEX.uri();
    }
}
