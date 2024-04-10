package com.example.demo1.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Locale;
@Entity
@Table(name = "deliveries")
@Data
public class Delivery {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private String address;
    private LocalDateTime date;
    private boolean confirmed;
    @Column(name = "customer_id")
    private String customerId;

}
