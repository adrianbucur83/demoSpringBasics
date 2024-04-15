package com.example.demo1.repository;

import com.example.demo1.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveriesRepository extends JpaRepository<Delivery, Integer> {
    List<Delivery> findAllByAddress(String address);
    @Query(value = "SELECT * FROM eshop.deliveries d WHERE d.address= :address", nativeQuery = true)
    List<Delivery> findAllByAddressNative(String address);

    @Query(value = "FROM Delivery d WHERE d.address= :address", nativeQuery = false)
    List<Delivery> findAllByAddressHybrid(String address);

    void deleteAllByAddress(String address);
}
