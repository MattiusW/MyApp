package com.mateuszwalczyk.buffetapp.domain;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@Component
public class Menu {

    List<String> menu = new ArrayList<String>();


    @RequestMapping("/menu")
    public List<String> menu(){
        return menu;
    }

    @Override
    public String toString(){
        return menu.toString();
    }

}
