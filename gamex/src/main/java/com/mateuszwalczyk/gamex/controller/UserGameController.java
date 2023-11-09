package com.mateuszwalczyk.gamex.controller;

import com.mateuszwalczyk.gamex.model.Game;
import com.mateuszwalczyk.gamex.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserGameController {

    @Autowired
    GameService gameService;

    //User game view
    @RequestMapping("/")
    public String userView(Model model){
        List<Game> userGame = gameService.getAllGameFromMemory();
        model.addAttribute("userView", userGame);
        return "userForm";
    }

    //Buy game by game id
//    @RequestMapping("/cart")
//    public String buyGame(@PathVariable Integer id, Model model){
//        Game gameToBuy = gameService.buyGameById(id);
//        model.addAttribute("buyGame", gameToBuy);
//        return "cartForm";
//    }

}
