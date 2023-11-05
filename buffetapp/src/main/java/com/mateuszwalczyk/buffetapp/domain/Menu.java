package com.mateuszwalczyk.buffetapp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Menu {

    @Autowired
    Dish description;

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
        return " Dish: " + this.dish + ", Price: " + this.price + ", Description: " + description;
    }

}
