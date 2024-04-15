package com.example.demo1.model.dto;

import com.example.demo1.model.Delivery;
import com.example.demo1.model.Review;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

@Data
public class DeliveryDto {
    private String address;
    private LocalDateTime date;
    private boolean confirmed;
    private String customerId;

    public Delivery toObject(DeliveryDto deliveryDto) {
        Delivery delivery = new Delivery();
        delivery.setAddress(deliveryDto.getAddress());
        delivery.setDate(deliveryDto.getDate());
        delivery.setConfirmed(deliveryDto.isConfirmed());
        return delivery;
    }

    public DeliveryDto toDto(Delivery delivery) {
        DeliveryDto deliveryDto = new DeliveryDto();
        deliveryDto.setAddress(delivery.getAddress());
        deliveryDto.setConfirmed(delivery.isConfirmed());
        deliveryDto.setDate(delivery.getDate());
        return deliveryDto;
    }

    //        BeanUtils.copyProperties(delivery, deliveryDto);

}
