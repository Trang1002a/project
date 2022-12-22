package com.example.project.controller;

import com.example.project.util.Pages;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class HomeController {

    @GetMapping("")
    public String index(Model model) {
//        List<Type> list = typeService.getList();
//        model.addAttribute(Layout.VIEW, list);
        return Pages.ADMIN_HOME_INDEX.uri();
    }
//    @GetMapping("/about")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    public String about(Model model) {
//
//        model.addAttribute(Layout.VIEW, Pages.ADMIN_ABOUT.uri());
//        return "index";
//    }
}
