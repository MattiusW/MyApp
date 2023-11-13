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
import java.math.RoundingMode;
import java.text.DecimalFormat;

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
    private BigDecimal price = BigDecimal.ZERO;
    @NotNull
    @Range(min = 1, max = 100)
    private BigDecimal howMany = BigDecimal.ZERO;

    @NotNull
    @Range(min = 1, max = 5)
    private int rate = 1;

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
        return price.setScale(2, RoundingMode.HALF_UP);
    }

    public void setPrice(BigDecimal price){
        this.price = price.setScale(2,RoundingMode.HALF_UP);
    }

    public BigDecimal getHowMany(){
        return howMany.setScale(0, RoundingMode.HALF_UP);
    }

    public void setHowMany(BigDecimal howMany){
        this.howMany = howMany.setScale(0, RoundingMode.HALF_UP);
    }

    public BigDecimal getCounter(){
        return counter;
    }

    public void setCounter(BigDecimal counter){
        this.counter = counter;
    }

    public int getRate(){
        return rate;
    }

    public void setRate(int rate){
        this.rate = rate;
    }

    @Override
    public String toString(){
        return "ID: " + this.id + " | Game: " + this.name + " | " + "Price: " + this.price + " | " + "How many: " + this.howMany + " | ";
    }



}
