package com.example.project.controller;

import com.example.project.model.entity.Type;
import com.example.project.service.Impl.TypeServiceImpl;
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
@RequestMapping("admin/type")
public class TypeController {
    @Autowired
    private TypeServiceImpl typeService;

    @GetMapping(value = {"", "/index"})
    public String index(Model model) {
        List<Type> list = typeService.findAll();
        model.addAttribute(Layout.VIEW, list);
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
