package com.mateuszwalczyk.gamex.utils;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class IdsTest {

    //Test if id is 0
    @Test
    public void testEmptySet(){
        int result = Ids.getNewID(Collections.emptySet());
        assertEquals(0, result);
    }

    @Test
    public void testGenerateNewId(){
        Set<Integer> sample = new HashSet<>();
        sample.add(5);
        sample.add(6);
        int result = Ids.getNewID(sample);
        assertEquals(7, result);
    }
}
