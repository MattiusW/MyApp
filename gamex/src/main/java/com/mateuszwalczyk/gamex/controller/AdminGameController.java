package com.mateuszwalczyk.gamex.controller;

import com.mateuszwalczyk.gamex.model.Game;
import com.mateuszwalczyk.gamex.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
//Class to connect with FrontEnd
public class AdminGameController {

    @Autowired
    GameService gameService;

    @RequestMapping("/admin/games")
    public String getTableOfGamesAdmin(Model model){
        List<Game> getAllAdminGames = gameService.getAllGameFromMemory();
        model.addAttribute("allAdminGameView", getAllAdminGames);
        return "adminGameViewForm";
    }

}
