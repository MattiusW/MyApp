package com.mateuszwalczyk.buffetapp.domain;
import org.springframework.stereotype.Component;

@Component
public class Dish {

    private String description;

    public Dish(String description){
        this.description = description;
    }

    @Override
    public String toString(){
        return description;
    }
}
