package com.example.demo1.model.dto;

import com.example.demo1.model.Delivery;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DeliveryReturnDto {
    private Integer id;
    private String address;
    private LocalDateTime date;
    private boolean confirmed;

    public Delivery toObject(DeliveryReturnDto deliveryDto) {
        Delivery delivery = new Delivery();
        delivery.setId(deliveryDto.getId());
        delivery.setAddress(deliveryDto.getAddress());
        delivery.setDate(deliveryDto.getDate());
        delivery.setConfirmed(deliveryDto.isConfirmed());
        return delivery;
    }

    public static DeliveryReturnDto toDto(Delivery delivery) {
        DeliveryReturnDto deliveryDto = new DeliveryReturnDto();
        deliveryDto.setAddress(delivery.getAddress());
        deliveryDto.setConfirmed(delivery.isConfirmed());
        deliveryDto.setDate(delivery.getDate());
        deliveryDto.setId(delivery.getId());
        return deliveryDto;
    }

    //        BeanUtils.copyProperties(delivery, deliveryDto);

}
