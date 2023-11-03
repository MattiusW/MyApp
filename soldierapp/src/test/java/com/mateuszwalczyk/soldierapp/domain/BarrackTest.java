package com.mateuszwalczyk.soldierapp.domain;

import com.mateuszwalczyk.soldierapp.domain.Barrack;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BarrackTest {
    @Autowired
    Barrack barrack;

    @Autowired
    Soldier soldier;

    @Test
    public void castleToStingMessage(){
        Mission mission = new Mission();
        Soldier soldier = new Soldier();
        soldier.setMission(mission);
        Barrack barrack = new Barrack("Black Barrack", soldier);
        String except = "Black Barrack| Soldier name: Bruce | Age: 29 | Mission: Example Mission";
        assertEquals(except, barrack.toString());
    }

}
