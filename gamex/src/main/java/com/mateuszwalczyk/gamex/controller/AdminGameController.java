package com.mateuszwalczyk.gamex.controller;

import com.mateuszwalczyk.gamex.model.Game;
import com.mateuszwalczyk.gamex.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
//Class to connect with FrontEnd
public class AdminGameController {

    @Autowired
    GameService gameService;

    //View all games in web page
    @RequestMapping("/admin/games")
    public String getTableOfGamesAdmin(Model model){
        List<Game> getAllAdminGames = gameService.getAllGameFromMemory();
        model.addAttribute("allAdminGameView", getAllAdminGames);
        return "adminGameViewForm";
    }

    //Add new game
    @RequestMapping("/admin/add")
    public String addNewGameOnWebPage(Model model){
        Game addGame = gameService.addNewGameToList();
        model.addAttribute("addNewGame", addGame);
        return "adminAddGameForm";
    }

    //Save game in repository
    @RequestMapping(value = "/admin/add", method = RequestMethod.POST)
    public String saveGameOnList(Game game){
        gameService.saveGame(game);
        return "redirect:/admin/games";
    }



}
