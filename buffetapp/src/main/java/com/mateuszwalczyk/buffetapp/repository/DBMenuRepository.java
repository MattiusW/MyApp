package com.mateuszwalczyk.buffetapp.repository;

import com.mateuszwalczyk.buffetapp.domain.Menu;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public class DBMenuRepository implements MenuRepositoryInterface {
    //CREATE
    @Override
    public void addDish(String dish, double price){
        throw new UnsupportedOperationException("Not implemented yet");
    }

    //Read
    @Override
    public Collection<Menu> getAllForMenu(){
        throw new UnsupportedOperationException("Not implemented yet");
    }

    //Read
    @Override
    public Optional<Menu> getDish(String dish){
        throw new UnsupportedOperationException("Not implemented yet");
    }

    //Delete
    @Override
    public void deleteMenu(Integer id){
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void randomMenu() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void addNewDish(Menu menu) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public Menu getDishById(Integer id) {
        throw new UnsupportedOperationException("Not implemented yet");
    }


}
