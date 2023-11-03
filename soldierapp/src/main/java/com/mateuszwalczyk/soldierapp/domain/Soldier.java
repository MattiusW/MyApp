package com.mateuszwalczyk.soldierapp.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class Soldier {


    private String name;
    private int age;

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

    public void setMission(Mission mission){
        this.mission = mission;
    }

    @Override
    public String toString(){
        return "| Soldier name: " + name + " | Age: " + age + " | Mission: " + mission;
    }

}
