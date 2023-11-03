package com.mateuszwalczyk.heroapp.model;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Entity
@Table(name = "Hero")
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Min(2)
    @Max(12)
    private String name;
    private int level;
    private int gold;

    public Hero(){
        this.level = 1;
        this.gold = 0;
    }

    public Hero(String name){
        this.name = name;
        this.level = 1;
        this.gold = 0;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getLevel(){
        return level;
    }

    public void setLevel(int level){
        this.level = level;
    }

    public int getGold(){
        return gold;
    }

    public void setGold(int gold){
        this.gold = gold;
    }

}
