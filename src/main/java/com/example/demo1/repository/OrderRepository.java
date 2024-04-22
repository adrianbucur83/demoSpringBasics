package com.example.demo1.repository;

import com.example.demo1.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAllByOrderStatus(String orderStatus);

    @Query(value ="SELECT * FROM orders o WHERE o.order_status = :order_status", nativeQuery = true)
    List<Order> findAllOrdersByStatus(String orderStatus);
}
