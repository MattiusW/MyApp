package com.mateuszwalczyk.buffetapp;

import com.mateuszwalczyk.buffetapp.domain.Menu;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuTest {
    @Autowired
    Menu menu;

    @Test
    public void menuTest(){
        Menu menu = new Menu(1L, "Fish", 10.00);
        Menu except = menu;
        assertEquals(except, menu);
    }


}
