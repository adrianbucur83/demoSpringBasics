package com.example.demo1.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

//@Getter
//@Setter
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Order {
    private Long orderId;
    private String customerName;
    private Long totalAmount;
//    private List<Product> products;
//    private LocalDateTime dateTime;
//    private String shippingAddress;
//    private String billingAddress;
//    private String paymentStatus;
//    private String shippingStatus;
//    private String paymentMethod;
//    private String orderStatus;
//    private String notes;

}
