package com.mateuszwalczyk.gamex.repository;

import com.mateuszwalczyk.gamex.model.Game;
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

    //Buy game by id
    public void buyGame(Integer id){
        if (memoryGameRepository.getGameById(id) == null)
        {
            System.out.println("Don't have a game");
        }
        else {
            Game gameToBuy = memoryGameRepository.getGameById(id);
            if (gameToBuy.getHowMany() == 0) {
                System.out.println("Out of stock");
            }
            else{
                cart.put(gameToBuy.getId(), gameToBuy);
                gameToBuy.setHowMany(gameToBuy.getHowMany() - 1); //subtract state
            }
        }
    }

    //Read all game in cart
    public Collection<Game> getGamesInCart(){
        return cart.values();
    }

    //Delete game in cart
    public void removeGame(Integer id){
        Game gameRemoveOnCart = memoryGameRepository.getGameById(id);
        //Add game to state if remove
        gameRemoveOnCart.setHowMany(gameRemoveOnCart.getHowMany() + 1);
        cart.remove(id);
    }

    @Override
    public String toString(){
        return "Cart repository{" + cart + " }";
    }

}
