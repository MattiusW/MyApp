package com.mateuszwalczyk.buffetapp.repository;

import com.mateuszwalczyk.buffetapp.domain.Menu;

import java.util.Collection;

public interface MenuRepositoryInterface {

    void addDish(String dish, double price);


    Collection<Menu> getAllForMenu();

    Menu getDish(String dish);

    void deleteMenu(String dish);

    void randomMenu();

    void addNewDish(Menu menu);
}
