package com.mateuszwalczyk.gamex.repository;

import com.mateuszwalczyk.gamex.model.Game;
import com.mateuszwalczyk.gamex.utils.Ids;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class MemoryGameRepository implements InterfaceGameRepository {

    //Save to map
    Map<Integer, Game> games = new HashMap<>();

    MemoryGameRepository(){

    }

    @Override
    public void addGame(String name, double price, int volume){
        Game newGame = new Game(name, price, volume);
        newGame.setId(Ids.getNewID(games.keySet()));
        games.put(newGame.getId(), newGame);
    }

    //Add new game UI user input
    @Override
    public void addNewGame(Game game){
        game.setId(Ids.getNewID(games.keySet()));
        games.put(game.getId(), game);
    }

    //Get all values from collection
    @Override
    public Collection<Game> getAllGames(){
        return games.values();
    }

    //Get game from id in collection
    @Override
    public Game getGameById(Integer id){
        return games.get(id);
    }


    //Get game from name in collection
    @Override
    public Optional<Game> getGameByName(String name){
        Optional<Game> gameName = games.values().stream().filter(game -> game.getName().equals(name)).findAny();
        return gameName;
    }

    //Remove object with id
    @Override
    public void deleteGame(Integer id){
        games.remove(id);
    }

    //Create few game on start applicaton
    @Override
    @PostConstruct
    public void randomGame(){
        addGame("The Witcher", 299.99, 1);
        addGame("BloodBorne", 99.99, 5);
        addGame("Heroes III", 39.99, 3);
    }


    @Override
    public String toString() {
        return "MemoryGameRepository{" +
                "games=" + games +
                '}';
    }
}
