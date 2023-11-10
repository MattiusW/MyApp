package com.mateuszwalczyk.gamex.model;

import org.springframework.stereotype.Component;

@Component
public class Cart {

    private double totalPrice;


    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
