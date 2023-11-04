package com.mateuszwalczyk.soldierapp.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Objects;

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

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Soldier soldier = (Soldier) o;
        return age == soldier.age;
    }

    @Override
    public int hashCode(){
        return Objects.hash(age);
    }

    public void setMission(Mission mission){
        this.mission = mission;
    }

    @Override
    public String toString(){
        return "| Soldier name: " + name + " | Age: " + age + " | Mission: " + mission;
    }

}
