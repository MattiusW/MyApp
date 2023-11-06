package com.mateuszwalczyk.buffetapp.controller;

import com.mateuszwalczyk.buffetapp.domain.Menu;
import com.mateuszwalczyk.buffetapp.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MenuController {

    @Autowired
    MenuService service;

    @RequestMapping("/menu")
    public String getDish(Model model){
        List<Menu> getAllDish = service.getAllMenu();
        model.addAttribute("AllMenu", getAllDish);
        return "guessMenuForm";
    }

    //Add dish to menu
    @RequestMapping("/add/menu")
    public String addToMenu(Model model){
        Menu addDish = service.addDishToMenu();
        model.addAttribute("addDishToMenu", addDish);
        return "addMenuForm";
    }

    //Save dish
    @RequestMapping(value = "/menu", method = RequestMethod.POST)
    public String saveDish(Menu menu){
        service.saveDish(menu);
        return "redirect:/menu";
    }

    //View dish
    @RequestMapping("/view")
    public String getDishOnMenu(@RequestParam("id") Integer id, Model model){
        Menu menu = service.getDishMenu(id);
        model.addAttribute("menu", menu);
        return "dishForm";
    }

    @RequestMapping("/delete/{id}")
    public String deleteDish(@PathVariable("id") Integer id){
        service.deleteDish(id);
        return "redirect:/menu";
    }

}
