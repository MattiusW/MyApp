package com.mateuszwalczyk.soldierapp.domain;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


public class Barrack {

    private String name;

    Soldier soldier;


    public Barrack(Soldier soldier){
        this.soldier = soldier;
    }

    Barrack(String name, Soldier soldier){
        this.name = name;
        this.soldier = soldier;
    }


    public void build(){
        System.out.println("Build barrack: " + name);
    }


    public void tearDown(){
        System.out.println("Destroy barrack: " + name);
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return name + soldier;
    }

}
