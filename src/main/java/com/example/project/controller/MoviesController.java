package com.example.project.controller;

import com.example.project.model.dto.BranchDTO;
import com.example.project.model.dto.MoviesDTO;
import com.example.project.model.entity.*;
import com.example.project.service.Impl.CountryServiceImpl;
import com.example.project.service.Impl.FormatServiceImpl;
import com.example.project.service.Impl.MoviesServiceImpl;
import com.example.project.service.Impl.TypeServiceImpl;
import com.example.project.util.Pages;
import com.example.project.util.mapper.MoviesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import com.example.project.util.Layout;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Objects;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
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
    @Autowired
    private ServletContext servletContext;

    private final MoviesMapper moviesMapper = new MoviesMapper();

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
        List<Type> types = typeService.findAll();
        List<Format> formats = formatService.findAll();
        List<Country> countries = countryService.findAll();
        List<MoviesDTO> listMovies = moviesMapper.mapListMoviesDTO(list, types, formats, countries);
        model.addAttribute(Layout.VIEW, listMovies);
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
    public String insert(@ModelAttribute("view") Movies movies, BindingResult bindingResult,
                         @RequestParam("upload") MultipartFile file, Model model) throws IOException {
        if (bindingResult.hasErrors()) {
            model.addAttribute("view", movies);
            return Pages.REDIRECT.uri() + Pages.ADMIN_MOVIES_INDEX.uri();
        } else {
            String fileName = servletContext.getRealPath("/") + "WEB-INF\\static\\images\\" + file.getOriginalFilename();
            movies.setImage(file.getOriginalFilename());
            try {
                file.transferTo(new File(fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Movies products = moviesService.save(movies);
            if (!Objects.isNull(products)) {
                return Pages.REDIRECT.uri() + Pages.ADMIN_MOVIES_INDEX.uri();
            } else {
                model.addAttribute("view", movies);
                return Pages.REDIRECT.uri() + Pages.ADMIN_MOVIES_INDEX.uri();
            }
        }
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
