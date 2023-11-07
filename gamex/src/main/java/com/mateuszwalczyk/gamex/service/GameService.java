package com.mateuszwalczyk.gamex.service;

import com.mateuszwalczyk.gamex.model.Game;
import com.mateuszwalczyk.gamex.repository.MemoryGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
//Indirect layer to connect between Backend and Frontend
public class GameService {

    @Autowired
    MemoryGameRepository memoryGameRepository;

    public List<Game> getAllGameFromMemory(){
        return new ArrayList<>(memoryGameRepository.getAllGames());
    }

    public Game addNewGameToList(){
        return new Game();
    }

    public void saveGame(Game game) {
        memoryGameRepository.addNewGame(game);
    }
}
