package com.example.demo1.service;

import com.example.demo1.model.Order;
import com.example.demo1.model.orderDto.OrderDto;

import java.util.List;
public interface OrderService {

    void createOrder(OrderDto orderDto);
    List<OrderDto> getAllOrdersByStatus(String orderStatus);
    Order getOrderById(Long id);
    List<OrderDto> getAllOrders();
    void updateOrder(OrderDto orderDto);
    void deleteOrder(Long id);


}
