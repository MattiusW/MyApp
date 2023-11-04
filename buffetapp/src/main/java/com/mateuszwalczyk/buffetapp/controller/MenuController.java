package com.mateuszwalczyk.buffetapp.controller;

import com.mateuszwalczyk.buffetapp.domain.Menu;
import com.mateuszwalczyk.buffetapp.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
public class MenuController {

    @Autowired
    MenuRepository menuRepository;

    //Post dish
    @PostMapping("/menu")
    public String addMenu(@RequestBody @Valid Menu menu, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            System.out.println("Wrong Data");
            return "Wrong data!";
        }

        menuRepository.save(menu);
        return "Correct data!";
    }

}
