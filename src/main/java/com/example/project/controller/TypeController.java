package com.example.project.controller;

import com.example.project.model.entity.Type;
import com.example.project.service.Impl.TypeServiceImpl;
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
@RequestMapping("admin/type")
public class TypeController {
    @Autowired
    private TypeServiceImpl typeService;

    @GetMapping(value = {"", "/index"})
    public String index(Model model,
                        @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                        @RequestParam(value = "name", required = false, defaultValue = "") String name) {
        int size = 5;
        Pageable pageable = PageRequest.of(page-1, size);
        Page<Type> pageType;
        if(name == null){
            pageType = typeService.findAll(pageable);
        } else {
            pageType = typeService.findByNameContaining(name, pageable);
        }
        List<Type> list = pageType.getContent();
        model.addAttribute(Layout.VIEW, list);
        model.addAttribute(Layout.CURRENT_PAGE, pageType.getNumber());
        model.addAttribute(Layout.TOTAL_ITEMS, pageType.getTotalElements());
        model.addAttribute(Layout.TOTAL_PAGES, pageType.getTotalPages());
        model.addAttribute(Layout.PAGE, size);
        model.addAttribute(Layout.NAME, name);
        return Pages.ADMIN_TYPE_INDEX.uri();
    }
    @GetMapping("/insert")
    public String insert(Model model) {
//        typeService.save(type);
        Type type = new Type();
        model.addAttribute("view", type);
        return Pages.ADMIN_TYPE_INSERT.uri();
    }
    @PostMapping("/insert")
    public String insert(Type type) {
        typeService.save(type);
        return Pages.REDIRECT.uri() + Pages.ADMIN_TYPE_INDEX.uri();
    }
    @GetMapping("/edit")
    public String edit(@PathParam("id") int id, Model model) {
        Type type = typeService.findById(id).get();
        model.addAttribute(Layout.VIEW, type);
        return Pages.ADMIN_TYPE_EDIT.uri();
    }
    @GetMapping("/delete")
    public String delete(@PathParam("id") int id, Model model) {
        typeService.deleteById(id);
        return Pages.REDIRECT.uri() + Pages.ADMIN_TYPE_INDEX.uri();
    }
}
