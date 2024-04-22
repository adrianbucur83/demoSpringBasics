package com.example.demo1.model.dto;

import com.example.demo1.model.Delivery;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@Data
public class DeliveryUpdateDto {
    private Integer id;
    @Length(min = 15)
    private String address;
    @NotNull
    private LocalDateTime date;
    private boolean confirmed;
    private String customerId;

    public Delivery toObject(DeliveryUpdateDto deliveryDto) {
        Delivery delivery = new Delivery();
        delivery.setId(deliveryDto.getId());
        delivery.setAddress(deliveryDto.getAddress());
        delivery.setDate(deliveryDto.getDate());
        delivery.setConfirmed(deliveryDto.isConfirmed());
        return delivery;
    }

    public static DeliveryUpdateDto toDto(Delivery delivery) {
        DeliveryUpdateDto deliveryDto = new DeliveryUpdateDto();
        deliveryDto.setAddress(delivery.getAddress());
        deliveryDto.setConfirmed(delivery.isConfirmed());
        deliveryDto.setDate(delivery.getDate());
        deliveryDto.setId(delivery.getId());
        deliveryDto.setCustomerId(deliveryDto.getCustomerId());
        return deliveryDto;
    }

    //        BeanUtils.copyProperties(delivery, deliveryDto);

}
