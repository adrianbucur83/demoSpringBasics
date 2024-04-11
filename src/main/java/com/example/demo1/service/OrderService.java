package com.example.demo1.service;

import com.example.demo1.model.Order;

import java.util.List;
public interface OrderService {

    Order createOrder(Order order);

    Order getOrderById(Long id);

    List<Order> getAllOrders();

    Order updateOrder(Order order);

    void deleteOrder(Long id);

}
