package com.mateuszwalczyk.gamex.service;

import com.mateuszwalczyk.gamex.model.Game;
import com.mateuszwalczyk.gamex.repository.MemoryCartRepository;
import com.mateuszwalczyk.gamex.repository.MemoryGameRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
//Indirect layer to connect between Backend and Frontend
public class GameService {

    @Autowired
    MemoryGameRepository memoryGameRepository;

    @Autowired
    MemoryCartRepository memoryCartRepository;


    public List<Game> getAllGameFromMemory(){
        return new ArrayList<>(memoryGameRepository.getAllGames());
    }

    public Game addNewGameToList(){
        return new Game();
    }

    public void saveGame(Game game) {
        memoryGameRepository.addNewGame(game);
    }

    public void deleteGame(Integer id){
        memoryGameRepository.deleteGame(id);
    }

    public List<Game> getAllGameFromCart(){
        return new ArrayList<>(memoryCartRepository.getGamesInCart());
    }

    //Indirect buy game
    public void gameToCart(Integer id){
        memoryCartRepository.addGameToCart(id);
    }

    public void deleteGameOnCart(Integer id){
        memoryCartRepository.removeGame(id);
    }
}
