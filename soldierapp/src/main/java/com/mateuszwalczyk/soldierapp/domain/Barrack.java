package com.mateuszwalczyk.soldierapp.domain;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Barrack {
    @Value("${my.barrack.name:East Watch}")
    private String name;

    Map<String, Soldier> soldiers = new HashMap<>();

    Barrack(){

    }
    Barrack(String name){
        this.name = name;

    }

    public void createSoldier(String name, int age){
        soldiers.put(name, new Soldier(name, age));
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
        return name ;
    }

}
