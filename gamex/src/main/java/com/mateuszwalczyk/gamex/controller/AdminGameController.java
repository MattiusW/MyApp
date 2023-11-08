package com.mateuszwalczyk.gamex.controller;

import com.mateuszwalczyk.gamex.model.Game;
import com.mateuszwalczyk.gamex.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
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
    public String saveGameOnList(@Valid Game game, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            System.out.println("Wrong value");
            //View on console all errors
            bindingResult.getAllErrors().forEach(error ->
                    System.out.println(error.getObjectName() + " " + error.getDefaultMessage()));
            //BindingResult need model attribute. Object from HTML.FORM and class model where is validation date.
            model.addAttribute("addNewGame", game);
            return "adminAddGameForm";
        }
        else {
            gameService.saveGame(game);
            return "redirect:/admin/games";
        }
    }

    //Delete game from list
    @RequestMapping("/admin/delete/{id}")
    public String deleteGame(@PathVariable("id") Integer id){
        gameService.deleteGame(id);
        return "redirect:/admin/games";
    }

}
