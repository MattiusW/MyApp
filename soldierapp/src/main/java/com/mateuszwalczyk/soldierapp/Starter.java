package com.mateuszwalczyk.soldierapp;

import com.mateuszwalczyk.soldierapp.domain.Barrack;
import com.mateuszwalczyk.soldierapp.domain.Mission;
import com.mateuszwalczyk.soldierapp.domain.Soldier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Starter implements CommandLineRunner {

    @Autowired
    Barrack barrack;

    @Override
    public void run(String... args) throws Exception{

        System.out.println("Barrack is here: " + barrack);

    }
}
