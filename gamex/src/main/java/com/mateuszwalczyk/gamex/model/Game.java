package com.mateuszwalczyk.gamex.model;

import org.springframework.stereotype.Component;

@Component
public class Game {

    private int id;
    private String name;
    private double price;
    private int howMany;

    public Game(){

    }

    public Game(int id, String name, double price, int howMany ){
        this.id = id;
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
