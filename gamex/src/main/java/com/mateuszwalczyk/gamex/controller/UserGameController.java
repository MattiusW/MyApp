package com.mateuszwalczyk.gamex.controller;

import com.mateuszwalczyk.gamex.model.Cart;
import com.mateuszwalczyk.gamex.model.Game;
import com.mateuszwalczyk.gamex.repository.MemoryGameRepository;
import com.mateuszwalczyk.gamex.service.GameService;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Controller
public class UserGameController {

    @Autowired
    GameService gameService;

    @Autowired
    Cart cartModel;


    //User game view
    @RequestMapping("/")
    public String userView(Model model){
        List<Game> userGame = gameService.getAllGameFromMemory();
        model.addAttribute("userView", userGame);
        return "userForm";
    }

    @RequestMapping("/cart")
    public String viewGamesInCart(Model model){
        List<Game> viewAllGameInCart = gameService.getAllGameFromCart();
        model.addAttribute("viewCart", viewAllGameInCart);
        model.addAttribute("cart", cartModel);
        return "cartForm";
    }

    @RequestMapping("/cart/delete/{id}")
    public String removeGameInCart(@PathVariable("id") Integer id){
        gameService.deleteGameOnCart(id);
        return "redirect:/cart";
    }

    @RequestMapping("/cart/buy/{id}")
    public String putGameToCart(@PathVariable("id") Integer id){
        gameService.gameToCart(id);
        return "redirect:/cart";
    }

    //Get single game to rate
    @GetMapping("/rate/{id}")
    public String viewRateGame(@PathVariable("id") Integer id, Model model){
        Game game = gameService.getSingleGame(id);
        model.addAttribute("setRate", game);
        return "rateForm";
    }

    //Send update value problem
    @PostMapping("/rate/{id}/add")
    public String changeRate(@PathVariable("id") Integer id, @ModelAttribute("setRate") Game game){
        Game setRateGame = gameService.getSingleGame(id);
        setRateGame.setRate(game.getRate());
        gameService.saveGame(game);
        return "redirect:/";
    }

}
