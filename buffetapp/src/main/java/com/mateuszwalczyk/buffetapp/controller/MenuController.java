package com.mateuszwalczyk.buffetapp.controller;

import com.mateuszwalczyk.buffetapp.domain.Menu;
import com.mateuszwalczyk.buffetapp.repository.MenuRepository;
import com.mateuszwalczyk.buffetapp.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MenuController {

    @Autowired
    MenuService service;

    @RequestMapping("/menu")
    public String getDish(Model model){
        List<Menu> getAllDish = service.getAllMenu();
        model.addAttribute("AllMenu", getAllDish);
        return "menuForm";
    }

}
