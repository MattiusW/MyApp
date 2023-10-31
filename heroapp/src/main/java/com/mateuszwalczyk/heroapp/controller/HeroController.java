package com.mateuszwalczyk.heroapp.controller;

import com.mateuszwalczyk.heroapp.model.Hero;
import com.mateuszwalczyk.heroapp.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HeroController {

    @Autowired
    private HeroRepository heroRepository;

    @PostMapping("/hero")
    Hero hero(@RequestBody Hero hero){
        return heroRepository.save(hero);
    }

    @GetMapping("/heroes")
    List<Hero> getAllHeroes(){
        return heroRepository.findAll();
    }

    //Create example hero with application start
    @EventListener(ApplicationReadyEvent.class)
    public void addHero(){
        hero(new Hero("Examp"));
    }

}
