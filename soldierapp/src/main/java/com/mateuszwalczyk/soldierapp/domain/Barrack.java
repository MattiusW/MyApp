package com.mateuszwalczyk.soldierapp.domain;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:barrack.properties")
public class Barrack {
    @Value("${my.barrack.name}")
    private String name;


    private Soldier soldier;

    @Autowired
    public Barrack(Soldier soldier){
        this.soldier = soldier;
    }

    Barrack(String name, Soldier soldier){
        this.name = name;
        this.soldier = soldier;
    }

    @PostConstruct
    public void buld(){
        System.out.println("Build barrack: " + name);
    }

    @PreDestroy
    public void tearDown(){
        System.out.println("Destroy barrack: " + name);
    }

    @Override
    public String toString(){
        return name + soldier;
    }

}
