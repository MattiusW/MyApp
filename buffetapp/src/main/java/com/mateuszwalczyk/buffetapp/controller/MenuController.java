package com.mateuszwalczyk.buffetapp.controller;

import com.mateuszwalczyk.buffetapp.domain.Menu;
import com.mateuszwalczyk.buffetapp.repository.MenuRepository;
import com.mateuszwalczyk.buffetapp.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MenuController {

    @Autowired
    MenuService service;

    @RequestMapping("/guess/menu")
    public String getDish(Model model){
        List<Menu> getAllDish = service.getAllMenu();
        model.addAttribute("AllMenu", getAllDish);
        return "guessMenuForm";
    }

    @RequestMapping("/add/menu")
    public String addToMenu(Model model){
        Menu addDish = service.addDishToMenu();
        model.addAttribute("addDishToMenu", addDish);
        return "addMenuForm";
    }

    @RequestMapping(value = "/guess/menu", method = RequestMethod.POST)
    public String saveDish(Menu menu){
        service.saveDish(menu);
        return "redirect:/guess/menu";
    }

}
