package com.knifed.bookstore.repositories;

import com.knifed.bookstore.entities.Order;
import com.knifed.bookstore.entities.OrderStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class OrderRepository {

    private List<Order> orderList;

    public OrderRepository(List<Order> orderList){
        this.orderList = orderList;
    }

    public List<Order> getOrderList() {
        return this.orderList;
    }

    public List<Order> getAllNotProcessedOrders() {
        return this.orderList.stream()
                .filter(o -> o.getStatus().equals(OrderStatus.NotProcessed))
                .collect(Collectors.toList());
    }

    public List<Order> getAllProcessedOrders() {
        return this.orderList.stream()
                .filter(o -> o.getStatus().equals(OrderStatus.Processed))
                .collect(Collectors.toList());
    }

    public List<Order> getAllCompletedOrders() {
        return this.orderList.stream()
                .filter(o -> o.getStatus().equals(OrderStatus.Completed))
                .collect(Collectors.toList());
    }

    public void addOrder(Order order){
        this.getOrderList().add(order);
    }

    public void editOrder(Order order) {
        Order editedOrder = this.getOrderList().stream()
                .filter(o -> o.getId() == order.getId())
                .findFirst()
                .orElse(null);

        int index = this.getOrderList().indexOf(editedOrder);
        this.getOrderList().set(index, order);
    }
}
