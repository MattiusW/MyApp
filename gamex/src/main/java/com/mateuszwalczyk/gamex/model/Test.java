package com.mateuszwalczyk.gamex.model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test {

    @RequestMapping("/test")
    public String hello(){
        return "hello";
    }

}
