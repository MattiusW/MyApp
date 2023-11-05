package com.mateuszwalczyk.buffetapp.controller;

import com.mateuszwalczyk.buffetapp.domain.Menu;
import com.mateuszwalczyk.buffetapp.repository.MenuRepository;
import com.mateuszwalczyk.buffetapp.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MenuController {

    @Autowired
    MenuService service;

    @RequestMapping("/menu")
    public String getDish(){
        service.getAllMenu();
        return "";
    }

}
