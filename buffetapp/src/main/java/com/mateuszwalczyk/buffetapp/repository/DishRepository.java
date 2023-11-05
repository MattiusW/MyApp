package com.mateuszwalczyk.buffetapp.repository;

import com.mateuszwalczyk.buffetapp.domain.Menu;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@Repository
public class DishRepository implements MenuRepository {

    Map<String, Menu> menus = new HashMap<>();

    //CREATE
    @Override
    public void addDish(String dish, double price){
        menus.put(dish, new Menu(dish, price));
    }

    //Read
    @Override
    public Collection<Menu> getAllForMenu(){
        return menus.values();
    }

    //Read
    @Override
    public Menu getDish(String dish){
        return menus.get(dish);
    }

    //Delete
    @Override
    public void deleteMenu(String dish){
        menus.remove(dish);
    }

    @Override
    @PostConstruct
    public void randomMenu(){
        addDish("Sushi", 59.99);
        addDish("Steak", 79.99);
        addDish("Dumplings with meat", 39.99);
    }

    @Override
    public String toString() {
        return "DishRepository{" +
                "menu=" + menus +
                '}';
    }
}
