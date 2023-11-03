package com.mateuszwalczyk.buffetapp.controller;

import com.mateuszwalczyk.buffetapp.domain.Menu;
import com.mateuszwalczyk.buffetapp.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MenuController {

    @Autowired
    MenuRepository menuRepository;

    @RequestMapping("/menu")
    public Menu addMenu(@RequestBody Menu menu){
        return menuRepository.save(menu);
    }

}
