package com.mateuszwalczyk.buffetapp.repository;

import com.mateuszwalczyk.buffetapp.domain.Menu;

import java.util.Collection;
import java.util.Optional;

public interface MenuRepositoryInterface {

    void addDish(String dish, double price);


    Collection<Menu> getAllForMenu();

    Optional<Menu> getDish(String dish);

    void deleteMenu(Integer id);

    void randomMenu();

    void addNewDish(Menu menu);

    Menu getDishById(Integer id);
}
