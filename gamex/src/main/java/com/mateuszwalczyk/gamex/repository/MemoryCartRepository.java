package com.mateuszwalczyk.gamex.repository;

import com.mateuszwalczyk.gamex.model.Game;
import com.mateuszwalczyk.gamex.utils.Ids;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.AssociationOverride;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class MemoryCartRepository {
    //User cart repository
    @Autowired
    MemoryGameRepository memoryGameRepository;

    HashMap<Integer, Game> cart = new HashMap<>();

    public void buyGame(Integer id){
        Game gameToBuy = memoryGameRepository.getGameById(id);
        gameToBuy.setId(Ids.getNewID(cart.keySet()));
        cart.put(gameToBuy.getId(), gameToBuy);
    }


    @Override
    public String toString(){
        return "Cart repository{" + cart + " }";
    }

}
