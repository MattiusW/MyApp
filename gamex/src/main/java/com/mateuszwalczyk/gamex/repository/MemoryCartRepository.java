package com.mateuszwalczyk.gamex.repository;

import com.mateuszwalczyk.gamex.model.Game;
import com.mateuszwalczyk.gamex.utils.Ids;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;

@Repository
public class MemoryCartRepository {
    //User cart repository
    @Autowired
    MemoryGameRepository memoryGameRepository;

    HashMap<Integer, Game> cart = new HashMap<>();

    //Buy game by Id
    public void buyGame(Integer id){
        if (memoryGameRepository.getGameById(id) == null)
        {
            System.out.println("Don't have a game");
        }
        else {
            Game gameToBuy = memoryGameRepository.getGameById(id);
            gameToBuy.setId(Ids.getNewID(cart.keySet()));
            cart.put(gameToBuy.getId(), gameToBuy);
        }
    }

    //Read all game in cart
    public Collection<Game> getGamesInCart(){
        return cart.values();
    }

    //Delete game in cart
    public void removeGame(Integer id){
        cart.remove(id);
    }


    @Override
    public String toString(){
        return "Cart repository{" + cart + " }";
    }

}
