package com.mateuszwalczyk.soldierapp.domain;

public class Soldier {

    private String name;
    private int age;

    private Mission mission;

    public Soldier(String name, int age, Mission mission){
        this.name = name;
        this.age = age;
        this.mission = mission;
    }

    @Override
    public String toString(){
        return "| Soldier name: " + name + " | Age: " + age + " | Mission: " + mission;
    }

}
