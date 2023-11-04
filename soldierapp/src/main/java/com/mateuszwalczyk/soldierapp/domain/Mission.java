package com.mateuszwalczyk.soldierapp.domain;

import org.springframework.stereotype.Component;

@Component
public class Mission {

    private String description;


    public Mission(){
        this.description = "Example Mission";
    }

    @Override
    public String toString(){
        return description;
    }

}
