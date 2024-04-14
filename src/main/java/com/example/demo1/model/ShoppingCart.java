package com.example.demo1.model;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
//@Data
//@Builder
@Entity
@Table(name="shopping_cart")
@Data
public class ShoppingCart {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private Integer productId;
    private String descriptionProduct;
    private Double unitPrice;
    private boolean availability;
    private LocalDate dateOfDelivery;
    private Integer customerId;
}
