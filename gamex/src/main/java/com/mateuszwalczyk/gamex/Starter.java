package com.mateuszwalczyk.gamex;

import com.mateuszwalczyk.gamex.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Starter implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception{
        //Test
        Game game = new Game(1,"Witcher", 129.99, 3);
        System.out.println(game);
    }
}
