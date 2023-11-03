package com.mateuszwalczyk.buffetapp;

import com.mateuszwalczyk.buffetapp.domain.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Starter implements CommandLineRunner {

    @Autowired
    Menu menu;

    public void run(String... args) throws Exception{
        System.out.println(menu);
    }
}
