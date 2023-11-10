package com.mateuszwalczyk.gamex.repository;

import com.mateuszwalczyk.gamex.model.Game;
import com.mateuszwalczyk.gamex.utils.Ids;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class MemoryGameRepositoryTest {

    Map<Integer, Game> testGamesRepository = new HashMap<>();

    @Test
    public void testAddGameWithNewId(){

        Game newGame = new Game("GameTest", 123.11, 2);
        newGame.setId(Ids.getNewID(testGamesRepository.keySet()));
        testGamesRepository.put(newGame.getId(), newGame);
        int result = newGame.getId();
        assertEquals(0, result);

    }
}
