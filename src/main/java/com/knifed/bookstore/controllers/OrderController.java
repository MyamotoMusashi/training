package com.knifed.bookstore.controllers;

import com.knifed.bookstore.entities.Order;
import com.knifed.bookstore.repositories.OrderRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    @GetMapping("/orders")
    public List<Order> getOrders(){
        return this.orderRepository.getOrderList();
    }

    @PostMapping("/orders")
    public void addOrder(@RequestBody Order order){
        this.orderRepository.addOrder(order);
    }

    @PutMapping("/orders")
    public void editOrder(@RequestBody Order order){
        this.orderRepository.editOrder(order);
    }
}
