package com.mateuszwalczyk.gamex.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;
import org.springframework.stereotype.Component;

@Component
public class Game {

    private int id;

    @NotNull
    @Size(min = 1, max = 15)
    private String name;
    @NotNull
    @Range(min = 19, max = 400)
    private double price;
    @NotNull
    @Range(min = 1, max = 100)
    private int howMany;

    public Game(){

    }

    public Game(String name, double price, int howMany ){
        this.name = name;
        this.price = price;
        this.howMany = howMany;
    }


    public int getId(){
        return this.id = id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public int getHowMany(){
        return howMany;
    }

    public void setHowMany(int howMany){
        this.howMany = howMany;
    }

    @Override
    public String toString(){
        return "ID: " + this.id + " | Game: " + this.name + " | " + "Price: " + this.price + " | " + "How many: " + this.howMany + " | ";
    }



}
