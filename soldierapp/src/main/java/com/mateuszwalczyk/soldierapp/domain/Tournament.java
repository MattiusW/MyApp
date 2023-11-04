package com.mateuszwalczyk.soldierapp.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Tournament {

    @Autowired
    Soldier soldier;

    public Tournament(){

    }

    public void battle(){
        soldier.setAge(soldier.getAge() + 1);
    }
    @Override
    public String toString(){
        return "In tournament take soldier: " + soldier;
    }
}
