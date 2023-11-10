package com.mateuszwalczyk.gamex.repository;

import com.mateuszwalczyk.gamex.model.Game;
import com.mateuszwalczyk.gamex.utils.Ids;
import org.junit.jupiter.api.Test;


import static org.junit.Assert.assertEquals;

public class MemoryGameRepositoryTest {

    @Test
    public void testAddGameWithNewId(){

        MemoryGameRepository memoryGameRepository = new MemoryGameRepository();
        Game newGame = new Game("GameTest", 123.11, 2);
        newGame.setId(Ids.getNewID(memoryGameRepository.games.keySet()));
        memoryGameRepository.games.put(newGame.getId(), newGame);
        int result = newGame.getId();
        assertEquals(0, result);

    }
}
