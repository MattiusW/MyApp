package com.mateuszwalczyk.buffetapp;

import com.mateuszwalczyk.buffetapp.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class Starter implements CommandLineRunner {

    @Autowired
    MenuRepository dishRepository;

    public void run(String... args) throws Exception{
        System.out.println(dishRepository);
    }
}
