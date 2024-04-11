package com.example.demo1.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private String customerName;
    private Long totalAmount;
    private LocalDateTime dateTime;
    private String shippingAddress;
    private String billingAddress;
    private String paymentStatus;
    private String shippingStatus;
    private String paymentMethod;
    private String orderStatus;
    private String notes;

    //    private List<Product> products;


}
