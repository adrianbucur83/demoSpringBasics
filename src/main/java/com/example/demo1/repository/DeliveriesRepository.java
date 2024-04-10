package com.example.demo1.repository;

import com.example.demo1.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveriesRepository extends JpaRepository<Delivery, Integer> {


    //todo stuff
}
