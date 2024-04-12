package com.example.demo1.mapper;

import com.example.demo1.model.Order;
import com.example.demo1.model.orderDto.OrderDto;

import java.time.LocalDateTime;

public class OrderMapper {
    public static Order mapToObject(OrderDto orderDto){

        Order order = new Order();
        order.setOrderId(orderDto.getOrderId());
        order.setCustomerName(orderDto.getCustomerName());
        order.setTotalAmount(orderDto.getTotalAmount());
        order.setDateTime(orderDto.getDateTime());
        order.setAddress(orderDto.getAddress());
        order.setOrderStatus(orderDto.isOrderStatus());
        order.setNotes(orderDto.getNotes());
        order.setUserId(orderDto.getUserId());

        return order;
    }

    public static OrderDto mapToDto(Order order){

        OrderDto orderDto = new OrderDto();
        orderDto.setOrderId(order.getOrderId());
        orderDto.setCustomerName(order.getCustomerName());
        orderDto.setTotalAmount(order.getTotalAmount());
        orderDto.setDateTime(LocalDateTime.now());
        orderDto.setAddress(order.getAddress());
        orderDto.setOrderStatus(order.isOrderStatus());
        orderDto.setNotes(order.getNotes());

        return orderDto;
    }
}
