package com.example.demo1.model.orderDto;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private Long orderId;
    private String customerName;
    private Long totalAmount;
    private String dateTime;
    private String address;
    private String orderStatus;
    private String notes;

}
