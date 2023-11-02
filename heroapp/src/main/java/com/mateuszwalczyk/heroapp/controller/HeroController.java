package com.mateuszwalczyk.heroapp.controller;

import com.mateuszwalczyk.heroapp.exception.HeroNotFoundException;
import com.mateuszwalczyk.heroapp.model.Hero;
import com.mateuszwalczyk.heroapp.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RestController
@CrossOrigin("http://localhost:3000")
@Validated
public class HeroController {

    private static final int MAX_HEROES = 3;


    @Autowired
    private HeroRepository heroRepository;

    //Post only five hero
    @PostMapping("/hero")
    ResponseEntity<Object> hero(@RequestBody @Valid Hero hero){
        if(heroRepository.count() >= MAX_HEROES){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Too many heroes!");
        }

        return ResponseEntity.ok(heroRepository.save(hero));
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

    @DeleteMapping("/hero/{id}")
    String deleteUser(@PathVariable Long id){
        if(!heroRepository.existsById(id)){
            throw new HeroNotFoundException(id);
        }
        heroRepository.deleteById(id);
        return "Hero with id " + id + " has been deleted success.";
    }

    //Create example hero with application start
    @EventListener(ApplicationReadyEvent.class)
    public void addHero(){
        hero(new Hero("Williamie Wallace"));
    }

}
