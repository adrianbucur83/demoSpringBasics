package com.example.demo1.model.dto;

import com.example.demo1.model.Delivery;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DeliveryDto {
    private String address;
    private LocalDateTime date;
    private boolean confirmed;

    public Delivery toObject(DeliveryDto deliveryDto) {
        Delivery delivery = new Delivery();
        delivery.setAddress(deliveryDto.getAddress());
        delivery.setDate(deliveryDto.getDate());
        delivery.setConfirmed(deliveryDto.isConfirmed());
        return delivery;
    }

    //        BeanUtils.copyProperties(delivery, deliveryDto);

}
