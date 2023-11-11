package com.mateuszwalczyk.gamex.repository;

import com.mateuszwalczyk.gamex.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
@Component
public class BestsellerRepository {
    @Autowired
    Game game;

    @Autowired
    MemoryCartRepository cartRepository;

    HashMap<Integer, Game> bestsellers = new HashMap<>();

    public void addToBestSeller(){
        if(cartRepository.cart.containsKey(game)){
            System.out.println("Yes");
        }
        else{
            System.out.println("Not have");
        }
    }



}
