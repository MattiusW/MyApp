package com.mateuszwalczyk.heroapp.exception;

public class HeroNotFoundException extends RuntimeException{
    public HeroNotFoundException(Long id){
        super("Could not found the hero with id " + id);
    }
}
