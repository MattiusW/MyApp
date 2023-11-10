package com.mateuszwalczyk.gamex.repository;

import com.mateuszwalczyk.gamex.model.Game;
import com.mateuszwalczyk.gamex.utils.Ids;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
    public void addGame(String name, BigDecimal price, BigDecimal volume){
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

    //Create few game on start application
    @Override
    @PostConstruct
    public void randomGame(){
        addGame("The Witcher", new BigDecimal(129.99).setScale(2, RoundingMode.HALF_UP), BigDecimal.ONE);
        addGame("BloodBorne", new BigDecimal(99.99).setScale(2,RoundingMode.HALF_UP), new BigDecimal(5));
        addGame("Heroes III", new BigDecimal(59.99).setScale(2, RoundingMode.HALF_UP), new BigDecimal(7));
    }


    @Override
    public String toString() {
        return "MemoryGameRepository{" +
                "games=" + games +
                '}';
    }
}
