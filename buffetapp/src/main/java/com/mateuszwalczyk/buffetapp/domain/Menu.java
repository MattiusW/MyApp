package com.mateuszwalczyk.buffetapp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Component;

@Component
@Entity
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 1, max = 12)
    private String dish;

    @NotNull
    private double price;

    public Menu(){
        super();
    }

    public Menu(Long id, String dish, double price){
        super();
        this.id = id;
        this.dish = dish;
        this.price = price;
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

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }


    public String toString(){
        return "| Id: " + this.id + " | Dish: " + this.dish + " | Price: " + price +"$ |";
    }

}
