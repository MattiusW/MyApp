package com.mateuszwalczyk.buffetapp.repository;

import com.mateuszwalczyk.buffetapp.domain.Menu;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@Repository
public class MenuRepository implements MenuRepositoryInterface {

    Map<Integer, Menu> menus = new HashMap<>();

    public MenuRepository(){

    }

    //CREATE
    @Override
    public void addDish(String dish, double price){

        Menu newDish = new Menu(dish, price);
        newDish.setId(getNewId());
        menus.put(newDish.getId(), newDish);
    }


    public int getNewId() {
        if(menus.isEmpty()){
            return 0;
        }
        else{
            Integer maxID = menus.keySet().stream().max(Integer::max).orElse(0);
            int newID = maxID + 1;
            while (menus.containsKey(newID)){
                newID++;
            }
            return newID;
        }
    }

    //Read all
    @Override
    public Collection<Menu> getAllForMenu(){
        return menus.values();
    }

    //Read
    @Override
    public Optional<Menu> getDish(String dish){

        Optional<Menu> dishByName = menus.values().stream().filter(menu -> menu.getDish().equals(dish)).findAny();

        return dishByName;
    }

    //Delete
    @Override
    public void deleteMenu(Integer id){
        menus.remove(id);
    }

    @Override
    @PostConstruct
    public void randomMenu(){
        addDish("Sushi", 59.99);
        addDish("Steak", 79.99);
        addDish("Dumplings", 39.99);
    }

    //Add dish with user input
    @Override
    public void addNewDish(Menu menu) {
        menu.setId(getNewId());
        menus.put(menu.getId(), menu);
    }

    @Override
    public Menu getDishById(Integer id) {
        return menus.get(id);
    }

    @Override
    public String toString() {
        return "MenuRepository{" +
                "menu=" + menus +
                '}';
    }
}
