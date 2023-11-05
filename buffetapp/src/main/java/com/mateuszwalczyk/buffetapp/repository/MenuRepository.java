package com.mateuszwalczyk.buffetapp.repository;

import com.mateuszwalczyk.buffetapp.domain.Menu;
import jakarta.annotation.PostConstruct;

import java.util.Collection;

public interface MenuRepository {

    void addDish(String dish, double price);


    Collection<Menu> getAllForMenu();

    Menu getDish(String dish);

    void deleteMenu(String dish);

    void randomMenu();
}
