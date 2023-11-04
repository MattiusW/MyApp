package com.mateuszwalczyk.soldierapp;

import com.mateuszwalczyk.soldierapp.domain.Barrack;
import com.mateuszwalczyk.soldierapp.domain.Mission;
import com.mateuszwalczyk.soldierapp.domain.Soldier;
import com.mateuszwalczyk.soldierapp.domain.Tournament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

@Component
public class Starter implements CommandLineRunner {

    @Autowired
    Barrack barrack;

    @Autowired
    Tournament tournament;

    @Override
    public void run(String... args) throws Exception{

        System.out.println(barrack);
        tournament.battle();
        System.out.println(tournament);
        System.out.println(barrack);

    }
}
