package com.mateuszwalczyk.buffetapp.controller;

import com.mateuszwalczyk.buffetapp.domain.Menu;
import com.mateuszwalczyk.buffetapp.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    MenuRepository menuRepository;

    @GetMapping("/viewMenu")
    public String viewMenuPage(Model model){
        model.addAttribute("menu", new Menu());
        return "menuForm.html";
    }


}
