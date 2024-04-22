package com.example.demo1.model.orderDto.mapper;

import com.example.demo1.model.Order;
import com.example.demo1.model.orderDto.OrderDto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OrderMapper {
    public static Order mapToObject(OrderDto orderDto){

        Order order = new Order();
        order.setOrderId(orderDto.getOrderId());
        order.setCustomerName(orderDto.getCustomerName());
        order.setTotalAmount(orderDto.getTotalAmount());
        String dateFormat = "dd-MM-yyyy HH:mm";
        DateTimeFormatter newDateTimeFormatter = DateTimeFormatter.ofPattern(dateFormat);
        order.setCreationDate(newDateTimeFormatter.format(LocalDateTime.now()));
        order.setAddress(orderDto.getAddress());
        order.setOrderStatus(orderDto.getOrderStatus());
        order.setNotes(orderDto.getNotes());


        return order;
    }
    public static OrderDto mapToDto(Order order){

        OrderDto orderDto = new OrderDto();
        orderDto.setOrderId(order.getOrderId());
        orderDto.setCustomerName(order.getCustomerName());
        orderDto.setTotalAmount(order.getTotalAmount());
        orderDto.setDateTime(order.getCreationDate());
        orderDto.setAddress(order.getAddress());
        orderDto.setOrderStatus(order.getOrderStatus());
        orderDto.setNotes(order.getNotes());

        return orderDto;
    }
}
