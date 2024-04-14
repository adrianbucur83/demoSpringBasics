package com.example.demo1.repository;

import com.example.demo1.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {

    List<ShoppingCart> findByDescriptionProduct(String description);

    @Query(value="SELECT * FROM public.shopping_cart s WHERE s.description_product = :description",
           nativeQuery = true)
    List<ShoppingCart> findByDescriptionProductNative(String description);

    @Query(value="FROM ShoppingCart s WHERE s.descriptionProduct = :description",
            nativeQuery = false)
    List<ShoppingCart> findByDescriptionProductHybrid(String description);

    List<ShoppingCart> findByUnitPrice(Double unitPrice);

    @Query(value="SELECT * FROM public.shopping_cart s WHERE s.date_of_delivery >= :deliveryDate",
            nativeQuery = true)
    List<ShoppingCart> findByDeliveryDate(LocalDate deliveryDate);

}
