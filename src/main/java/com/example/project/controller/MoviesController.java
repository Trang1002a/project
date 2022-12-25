package com.example.project.controller;

import com.example.project.model.entity.Country;
import com.example.project.model.entity.Format;
import com.example.project.model.entity.Movies;
import com.example.project.model.entity.Type;
import com.example.project.service.Impl.CountryServiceImpl;
import com.example.project.service.Impl.FormatServiceImpl;
import com.example.project.service.Impl.MoviesServiceImpl;
import com.example.project.service.Impl.TypeServiceImpl;
import com.example.project.util.Pages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import com.example.project.util.Layout;
import java.util.List;

import javax.websocket.server.PathParam;

@Controller
@RequestMapping("admin/movies")
public class MoviesController {
    @Autowired
    private MoviesServiceImpl moviesService;
    @Autowired
    private TypeServiceImpl typeService;
    @Autowired
    private CountryServiceImpl countryService;
    @Autowired
    private FormatServiceImpl formatService;

    @GetMapping(value = {"", "/index"})
    public String index(Model model,
                        @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                        @RequestParam(value = "name", required = false, defaultValue = "") String name) {
        int size = 5;
        Pageable pageable = PageRequest.of(page-1, size);
        Page<Movies> page_;
        if(name == null){
            page_ = moviesService.findAll(pageable);
        } else {
            page_ = moviesService.findByNameContaining(name, pageable);
        }
        List<Movies> list = page_.getContent();
        model.addAttribute(Layout.VIEW, list);
        model.addAttribute(Layout.CURRENT_PAGE, page_.getNumber());
        model.addAttribute(Layout.TOTAL_ITEMS, page_.getTotalElements());
        model.addAttribute(Layout.TOTAL_PAGES, page_.getTotalPages());
        model.addAttribute(Layout.PAGE, size);
        model.addAttribute(Layout.NAME, name);
        return Pages.ADMIN_MOVIES_INDEX.uri();
    }
    @GetMapping("/insert")
    public String insert(Model model) {
        Movies movies = new Movies();
        List<Type> type = typeService.findAll();
        List<Country> country = countryService.findAll();
        List<Format> format = formatService.findAll();
        model.addAttribute(Layout.TYPE, type);
        model.addAttribute(Layout.COUNTRY, country);
        model.addAttribute(Layout.FORMAT, format);
        model.addAttribute(Layout.VIEW, movies);
        return Pages.ADMIN_MOVIES_INSERT.uri();
    }
    @PostMapping("/insert")
    public String insert(Movies movies) {
        moviesService.save(movies);
        return Pages.REDIRECT.uri() + Pages.ADMIN_MOVIES_INDEX.uri();
    }
    @GetMapping("/edit")
    public String edit(@PathParam("id") int id, Model model) {
        Movies movies = moviesService.findById(id).get();
        List<Type> type = typeService.findAll();
        List<Country> country = countryService.findAll();
        List<Format> format = formatService.findAll();
        model.addAttribute(Layout.TYPE, type);
        model.addAttribute(Layout.COUNTRY, country);
        model.addAttribute(Layout.FORMAT, format);
        model.addAttribute(Layout.VIEW, movies);
        return Pages.ADMIN_MOVIES_EDIT.uri();
    }
    @GetMapping("/delete")
    public String delete(@PathParam("id") int id, Model model) {
        moviesService.deleteById(id);
        return Pages.REDIRECT.uri() + Pages.ADMIN_MOVIES_INDEX.uri();
    }
}
