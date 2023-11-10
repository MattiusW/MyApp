package com.mateuszwalczyk.gamex.model;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

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
