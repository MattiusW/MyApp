package com.mateuszwalczyk.buffetapp.domain;
import org.springframework.stereotype.Component;

@Component
public class DishTime {

    private String time;

    private DishTime(){

    }

    public DishTime(String time){
        this.time = time;
    }

    @Override
    public String toString(){
        return time;
    }
}
