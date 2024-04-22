package com.example.demo1.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
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

    @OneToOne
    private User user;

    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name = "deliveries_products",
              joinColumns = @JoinColumn(name = "delivery_id", referencedColumnName = "id"),
              inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"))
    private List<Product> products;

}
