package com.mateuszwalczyk.gamex.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Size(min = 1, max = 15)
    private String name;
    @NotNull
    @Range(min = 19, max = 400)
    private BigDecimal price;
    @NotNull
    @Range(min = 1, max = 100)
    private BigDecimal howMany;

    private BigDecimal counter = BigDecimal.ZERO;

    public Game(){

    }

    public Game(String name, BigDecimal price, BigDecimal howMany){
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

    public BigDecimal getPrice(){
        return price;
    }

    public void setPrice(BigDecimal price){
        this.price = price;
    }

    public BigDecimal getHowMany(){
        return howMany;
    }

    public void setHowMany(BigDecimal howMany){
        this.howMany = howMany;
    }

    public BigDecimal getCounter(){
        return counter;
    }

    public void setCounter(BigDecimal counter){
        this.counter = counter;
    }

    @Override
    public String toString(){
        return "ID: " + this.id + " | Game: " + this.name + " | " + "Price: " + this.price + " | " + "How many: " + this.howMany + " | ";
    }



}
