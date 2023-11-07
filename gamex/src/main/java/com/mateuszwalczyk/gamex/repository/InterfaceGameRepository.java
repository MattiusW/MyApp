package com.mateuszwalczyk.gamex.repository;

import com.mateuszwalczyk.gamex.model.Game;
import jakarta.annotation.PostConstruct;

import java.util.Collection;
import java.util.Optional;

public interface InterfaceGameRepository {
    void addGame(String name, double price, int volume);

    //Get all values from collection
    Collection<Game> getAllGames();

    //Get game from id in collection
    Game getGameById(Integer id);

    //Get game from name in collection
    Optional<Game> getGameByName(String name);

    //Remove object with id
    void deleteMenu(Integer id);

    //Create few game on start applicaton
    void randomGame();
}
