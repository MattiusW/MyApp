package com.mateuszwalczyk.heroapp.controller;

import com.mateuszwalczyk.heroapp.model.Hero;
import com.mateuszwalczyk.heroapp.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HeroController {

    @Autowired
    private HeroRepository heroRepository;

    @PostMapping("/hero")
    Hero newHero(@RequestBody Hero newHero){
        return heroRepository.save(newHero);
    }

    @GetMapping("/heroes")
    List<Hero> getAllHeroes(){
        return heroRepository.findAll();
    }

}