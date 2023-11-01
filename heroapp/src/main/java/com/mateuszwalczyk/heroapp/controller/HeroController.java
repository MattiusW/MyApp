package com.mateuszwalczyk.heroapp.controller;

import com.mateuszwalczyk.heroapp.exception.HeroNotFoundException;
import com.mateuszwalczyk.heroapp.model.Hero;
import com.mateuszwalczyk.heroapp.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
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

    @GetMapping("/hero/{id}")
    Hero getHeroById(@PathVariable Long id){
        return heroRepository.findById(id)
                .orElseThrow(() -> new HeroNotFoundException(id));
    }

    @PutMapping("/hero/{id}")
    Hero updateHero(@RequestBody Hero newHero, @PathVariable Long id){
        return heroRepository.findById(id).map(hero -> {
            hero.setName(newHero.getName());
            return heroRepository.save(hero);
        }).orElseThrow(() -> new HeroNotFoundException(id));
    }


    //Create example hero with application start
    @EventListener(ApplicationReadyEvent.class)
    public void addHero(){
        hero(new Hero("Examp"));
    }

}
