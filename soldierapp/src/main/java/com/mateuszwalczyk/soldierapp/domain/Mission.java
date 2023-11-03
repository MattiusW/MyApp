package com.mateuszwalczyk.soldierapp.domain;

public class Mission {

    private String description;

    public Mission(String description){
        this.description = description;
    }

    @Override
    public String toString(){
        return description;
    }

}
