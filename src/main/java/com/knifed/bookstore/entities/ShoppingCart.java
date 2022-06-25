package com.knifed.bookstore.entities;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class ShoppingCart {
    private HashMap<String, Order> orders;

    public ShoppingCart(){
        this.setOrders(new HashMap<>());
    };

    public ShoppingCart(HashMap<String, Order> orders){
        this.setOrders(orders);
    }

    public HashMap<String,Order> getOrders() {
        return this.orders;
    }

    public void setOrders(HashMap<String, Order> orders) {
        this.orders = orders;
    }
}