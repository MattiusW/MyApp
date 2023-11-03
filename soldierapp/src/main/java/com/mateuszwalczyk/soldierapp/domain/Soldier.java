package com.mateuszwalczyk.soldierapp.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Soldier {


    private String name = "Bruce";
    private int age = 29;

    private Mission mission;

    public Soldier(){

    }

    public Soldier(String name,int age){
        this.name = name;
        this.age = age;
    }

//    public Soldier(String name, int age, Mission mission){
//        this.name = name;
//        this.age = age;
//        this.mission = mission;
//    }

    @Autowired
    public void setMission(Mission mission){
        this.mission = mission;
    }

    @Override
    public String toString(){
        return "| Soldier name: " + name + " | Age: " + age + " | Mission: " + mission;
    }

}
