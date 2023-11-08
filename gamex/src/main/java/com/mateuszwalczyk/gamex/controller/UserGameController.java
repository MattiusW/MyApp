package com.mateuszwalczyk.gamex.controller;

import com.mateuszwalczyk.gamex.model.Game;
import com.mateuszwalczyk.gamex.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserGameController {

    @Autowired
    GameService userService;

    @RequestMapping("/")
    public String userView(Model model){
        List<Game> userGame = userService.getAllGameFromMemory();
        model.addAttribute("userView", userGame);
        return "userForm";
    }

//    @RequestMapping("/cart")
//    public String cart(Model model){
//
//    }

}
