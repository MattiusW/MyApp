package com.mateuszwalczyk.buffetapp.services;

import com.mateuszwalczyk.buffetapp.domain.Menu;
import com.mateuszwalczyk.buffetapp.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
//Important:
//Require class service to connect between FrontEnd and BackEnd
@Service
public class MenuService {

    @Autowired
    MenuRepository repository;

    public List<Menu> getAllMenu(){
        return new ArrayList<>(repository.getAllForMenu());
    }

    public Menu addDishToMenu(){
        return new Menu();
    }

    public void saveDish(Menu menu) {
        repository.addNewDish(menu);
    }

    public Menu getDishMenu(Integer id) {
        return repository.getDishById(id);
    }

    public void deleteDish(Integer id) {
        repository.deleteMenu(id);
    }
}
