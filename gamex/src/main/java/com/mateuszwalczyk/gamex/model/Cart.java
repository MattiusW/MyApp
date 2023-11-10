package com.mateuszwalczyk.gamex.model;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Cart {

    private BigDecimal totalPrice;

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
