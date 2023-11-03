package com.mateuszwalczyk.buffetapp.domain;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestController
@Component
public class Menu {

    String menu = "Empty menu";
    @RequestMapping("/menu")
    public String menu(){
        return menu;
    }

    @Override
    public String toString(){
        return menu;
    }

}
