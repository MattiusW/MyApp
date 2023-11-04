package com.mateuszwalczyk.buffetapp.controller;

import com.mateuszwalczyk.buffetapp.domain.Menu;
//import com.mateuszwalczyk.buffetapp.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/menu")
public class MenuController {

//    @Autowired
//    MenuRepository menuRepository;

    Map<Long, Menu> menus = new HashMap<>();

    public void addMenu(Long id, String name, double price){
        menus.put(id, new Menu(id, name, price));
    }

    public Collection<Menu> getAllForMenu(){
        return menus.values();
    }

    public Menu getMenu(Long id){
        return menus.get(id);
    }

    public void deleteMenu(Long id){
        menus.remove(id);
    }


//    @GetMapping("/viewMenu")
//    public String viewMenuPage(Model model){
//        model.addAttribute("menu", new Menu());
//        return "menuForm.html";
//    }


}
