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
    private String address;
    private boolean orderStatus;
    private String notes;
    private Long userId;


}
