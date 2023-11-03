package com.mateuszwalczyk.buffetapp;

import com.mateuszwalczyk.buffetapp.domain.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Starter implements CommandLineRunner {


    public void run(String... args) throws Exception{
        Menu menu = new Menu(1L, "Fish");
        System.out.println(menu);
    }
}
