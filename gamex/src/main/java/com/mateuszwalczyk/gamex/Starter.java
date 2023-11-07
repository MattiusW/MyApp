package com.mateuszwalczyk.gamex;

import com.mateuszwalczyk.gamex.model.Game;
import com.mateuszwalczyk.gamex.repository.MemoryGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Starter implements CommandLineRunner {
    @Autowired
    MemoryGameRepository gameRepository;

    @Override
    public void run(String... args) throws Exception{
        System.out.println(gameRepository);
    }
}
