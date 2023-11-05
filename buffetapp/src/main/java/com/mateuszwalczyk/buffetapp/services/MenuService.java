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

}