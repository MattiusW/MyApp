package com.mateuszwalczyk.soldierapp.domain;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Barrack {

    private String name = "East Watch";

    public Barrack(){

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
        return name;
    }

}
