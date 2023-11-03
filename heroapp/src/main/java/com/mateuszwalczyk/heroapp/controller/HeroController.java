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
import org.springframework.ui.ModelMap;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Controller
@RestController
@CrossOrigin("http://localhost:3000")
@Validated
public class HeroController {

    private static final int MAX_HEROES = 3; //User may have only three heroes

    @Autowired
    private HeroRepository heroRepository;

    //Post only three hero
    @PostMapping("/hero")
    @ResponseBody
    ResponseEntity<Object> hero(@RequestBody @Valid Hero hero, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("There were erros");
            bindingResult.getAllErrors().forEach(objectError -> {
                System.out.println(objectError.getObjectName() + " " + objectError.getDefaultMessage());
            });
        }

        if (heroRepository.count() >= MAX_HEROES) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Too many heroes!");
        }
        return ResponseEntity.ok(heroRepository.save(hero));
    }


    @GetMapping("/heroes")
    List<Hero> getAllHeroes() {
        return heroRepository.findAll();
    }

    @GetMapping("/hero/{id}")
    Hero getHeroById(@PathVariable Long id) {
        return heroRepository.findById(id)
                .orElseThrow(() -> new HeroNotFoundException(id));
    }

    @PutMapping("/hero/{id}")
    Hero updateHero(@RequestBody Hero newHero, @PathVariable Long id) {
        return heroRepository.findById(id).map(hero -> {
            hero.setName(newHero.getName());
            return heroRepository.save(hero);
        }).orElseThrow(() -> new HeroNotFoundException(id));
    }

    @DeleteMapping("/hero/{id}")
    String deleteUser(@PathVariable Long id) {
        if (!heroRepository.existsById(id)) {
            throw new HeroNotFoundException(id);
        }
        heroRepository.deleteById(id);
        return "Hero with id " + id + " has been deleted success.";
    }

    //Create example hero with application start
//    @EventListener(ApplicationReadyEvent.class)
//    public void addHero() {
//        hero(new Hero("Braveheart"));
//
//    }
}
