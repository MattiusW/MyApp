package com.mateuszwalczyk.soldierapp;

import com.mateuszwalczyk.soldierapp.domain.Mission;
import com.mateuszwalczyk.soldierapp.domain.Soldier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Starter implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception{

        Mission killing = new Mission("Kill them all");
        Mission rescue = new Mission("Rescue all");

        Soldier arnold = new Soldier("Arnold", 36, killing);
        Soldier sylvester = new Soldier("Sylvester", 32, rescue);
        System.out.println(arnold);
        System.out.println(sylvester);

    }
}
