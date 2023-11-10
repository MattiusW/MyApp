package com.mateuszwalczyk.gamex.repository;

import com.mateuszwalczyk.gamex.model.Cart;
import com.mateuszwalczyk.gamex.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;

@Repository
@Component
public class MemoryCartRepository {
    //User cart repository
    @Autowired
    MemoryGameRepository memoryGameRepository;
    @Autowired
    Cart cartModel;
    private double total;

    HashMap<Integer, Game> cart = new HashMap<>();;

    //Buy game by id
    public void addGameToCart(Integer id){
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
                gameToBuy.setCounter(gameToBuy.getCounter() + 1); //Increase counter
                total = total + gameToBuy.getPrice(); //View total price
                cartModel.setTotalPrice(total);
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
        //Handle null exception
        if(gameRemoveOnCart == null){
            cart.remove(id);
        }
        else {
            //Add game to state if remove
            gameRemoveOnCart.setHowMany(gameRemoveOnCart.getHowMany() + gameRemoveOnCart.getCounter());
            cart.remove(id);
            gameRemoveOnCart.setCounter(0); //reset counter
        }
    }

    @Override
    public String toString(){
        return "Cart repository{" + cart + " }";
    }

}
