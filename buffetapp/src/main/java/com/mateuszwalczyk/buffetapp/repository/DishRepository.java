package com.mateuszwalczyk.buffetapp.repository;

import com.mateuszwalczyk.buffetapp.domain.Menu;
//import com.mateuszwalczyk.buffetapp.repository.MenuRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@Repository
public class DishRepository {

    Map<String, Menu> menus = new HashMap<>();

    //CREATE
    public void addDish(String dish, double price){
        menus.put(dish, new Menu(dish, price));
    }

    //Read
    public Collection<Menu> getAllForMenu(){
        return menus.values();
    }

    //Read
    public Menu getDish(String dish){
        return menus.get(dish);
    }

    //Delete
    public void deleteMenu(String dish){
        menus.remove(dish);
    }

    public void randomMenu(){
        addDish("Sushi", 59.99);
        addDish("Steak", 79.99);
        addDish("Dumplings with meat", 39.99);
    }

    @Override
    public String toString() {
        return "DishRepository{" +
                "menus=" + menus +
                '}';
    }

}
