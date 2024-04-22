package com.example.demo1.service.impl;

import com.example.demo1.mapper.OrderMapper;
import com.example.demo1.model.Order;
import com.example.demo1.model.orderDto.OrderDto;
import com.example.demo1.repository.OrderRepository;
import com.example.demo1.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    @Override
    public void createOrder(OrderDto orderDto) {

        Order order = OrderMapper.mapToObject(orderDto);
        orderRepository.save(order);
    }

    @Override
    public List<OrderDto> getAllOrders() {
        List<OrderDto> orders = orderRepository
                .findAll()
                .stream()
                .map(OrderMapper::mapToDto)
                .toList();
        return orders;
    }
    @Override
    public List<OrderDto> getAllOrdersByStatus() {
        List<OrderDto> orders = orderRepository
                .findAllByOrderStatusTrue()
                .stream()
                .map(OrderMapper::mapToDto)
                .toList();
        return orders;
    }

    @Override
    public List<OrderDto> getAllOrdersBySetStatus() {
        List<OrderDto> orders = orderRepository
                .findAllOrdersByStatus()
                .stream()
                .map(OrderMapper::mapToDto)
                .toList();
        return orders;
    }

    @Override
    public Order getOrderById(Long id) {

        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order with id: " + id + " doesn't exists."));
        return order;
    }
    @Override
    public void updateOrder(OrderDto orderDto) {
        Order order = getOrderById(orderDto.getOrderId());
        order.setCustomerName(orderDto.getCustomerName());
        order.setTotalAmount(orderDto.getTotalAmount());
//        order.setCreationDate(orderDto.getDateTime());
        order.setOrderStatus(orderDto.isOrderStatus());
        order.setAddress(orderDto.getAddress());
        order.setNotes(orderDto.getNotes());
        orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
