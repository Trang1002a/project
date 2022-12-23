package com.example.project.controller;

import com.example.project.model.entity.Type;
import com.example.project.service.Impl.TypeServiceImpl;
import com.example.project.util.Pages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.websocket.server.PathParam;

@Controller
@RequestMapping("admin/branch")
public class BranchController {
    @Autowired
    private TypeServiceImpl typeService;

    @GetMapping(value = {"", "/index"})
    public String index(Model model) {
//        List<Type> list = typeService.findAll();
//        model.addAttribute(Layout.VIEW, list)s;
        return Pages.ADMIN_BRANCH_INDEX.uri();
    }
    @GetMapping("/insert")
    public String insert(Type type) {
//        typeService.save(type);
        return Pages.ADMIN_BRANCH_INSERT.uri();
    }
    @GetMapping("/{id}")
    public String edit(@PathParam("id") int id) {
//        Type type = typeService.findById(id).get();
        return Pages.ADMIN_BRANCH_EDIT.uri();
    }
}