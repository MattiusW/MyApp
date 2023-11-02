package com.mateuszwalczyk.heroapp.model;

import jakarta.persistence.*;

import javax.validation.constraints.Size;

@Entity
@Table(name = "Hero")
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Name")
    @Size(min = 1, max = 20) //validation name
    private String name;
    @Column(name ="Level")
    private int level;
    @Column(name = "Gold")
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
