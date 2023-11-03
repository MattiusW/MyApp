package com.mateuszwalczyk.buffetapp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.stereotype.Component;

@Component
@Entity
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dish;

    public Menu(){

    }

    public Menu(Long id, String dish){
        this.id = id;
        this.dish = dish;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getDish(){
        return dish;
    }

    public void setDish(String dish){
        this.dish = dish;
    }

    public String toString(){
        return "| Id: " + this.id + " | Dish: " + this.dish + " |";
    }

}
