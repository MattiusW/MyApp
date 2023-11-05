package com.mateuszwalczyk.buffetapp.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Menu {

    @Autowired
    DishTime dishTime;

    private String dish;

    private double price;

    public Menu(){

    }

    public Menu(String dish, double price){
        this.dish = dish;
        this.price = price;
    }

//    public Long getId(){
//        return id;
//    }

//    public void setId(Long id){
//        this.id = id;
//    }

    public String getDish(){
        return dish;
    }

    public void setDish(String dish){
        this.dish = dish;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }


    public String toString(){
        return " DishTime: " + this.dish + ", Price: " + this.price + ", Time: " + dishTime;
    }

}
