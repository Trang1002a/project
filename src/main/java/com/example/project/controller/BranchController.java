package com.example.project.controller;

import com.example.project.model.dto.BranchDTO;
import com.example.project.model.entity.Branch;
import com.example.project.model.entity.Room;
import com.example.project.service.Impl.BranchServiceImpl;
import com.example.project.service.Impl.RoomServiceImpl;
import com.example.project.util.Pages;
import com.example.project.util.mapper.BranchMapper;
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

import java.util.Arrays;
import java.util.List;

import javax.websocket.server.PathParam;

@Controller
@RequestMapping("admin/branch")
public class BranchController {
    @Autowired
    private BranchServiceImpl branchService;

    @Autowired
    private RoomServiceImpl roomService;

    @Autowired
    private final BranchMapper branchMapper = new BranchMapper();

    @GetMapping(value = {"", "/index"})
    public String index(Model model,
                        @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                        @RequestParam(value = "name", required = false, defaultValue = "") String name) {
        int size = 5;
        Pageable pageable = PageRequest.of(page-1, size);
        Page<Branch> page_;
        if(name == null){
            page_ = branchService.findAll(pageable);
        } else {
            page_ = branchService.findByNameContaining(name, pageable);
        }
        List<Branch> list = page_.getContent();
        List<Room> room = roomService.findAll();
        List<BranchDTO> listBranch = branchMapper.mapListBranchDTO(list, room);
        model.addAttribute(Layout.VIEW, listBranch);
        model.addAttribute(Layout.CURRENT_PAGE, page_.getNumber());
        model.addAttribute(Layout.TOTAL_ITEMS, page_.getTotalElements());
        model.addAttribute(Layout.TOTAL_PAGES, page_.getTotalPages());
        model.addAttribute(Layout.PAGE, size);
        model.addAttribute(Layout.NAME, name);
        return Pages.ADMIN_BRANCH_INDEX.uri();
    }
    @GetMapping("/insert")
    public String insert(Model model) {
        BranchDTO branch = new BranchDTO();
//        List<Room> list = roomService.findAll();
//        model.addAttribute(Layout.ROOM, list);
        model.addAttribute(Layout.VIEW, branch);
        return Pages.ADMIN_BRANCH_INSERT.uri();
    }
    @PostMapping("/insert")
    public String insert(BranchDTO branchDto) {
//        String[] a = branch.getRoom_id().split(",");
//        branch.setTotal(String.valueOf(a.length));
        Branch branch = branchMapper.mapToBranch(branchDto);
//        branchService.save(branch);
//        List<Room> rooms = branchService.getListRoom(branch.getId(), branchDto.getRoom());
//        roomService.saveAll(rooms);
        return Pages.REDIRECT.uri() + Pages.ADMIN_BRANCH_INDEX.uri();
    }
    @GetMapping("/edit")
    public String edit(@PathParam("id") int id, Model model) {
        Branch branch = branchService.findById(id).get();
//        List<Room> list = roomService.findByBranch_idIn(branch.getId());
//        model.addAttribute(Layout.ROOM, list);
        model.addAttribute(Layout.VIEW, branch);
        return Pages.ADMIN_BRANCH_EDIT.uri();
    }
    @GetMapping("/delete")
    public String delete(@PathParam("id") int id, Model model) {
        branchService.deleteById(id);
        return Pages.REDIRECT.uri() + Pages.ADMIN_BRANCH_INDEX.uri();
    }
}
