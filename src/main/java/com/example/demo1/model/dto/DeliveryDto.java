package com.example.demo1.model.dto;

import com.example.demo1.model.Delivery;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@Data
public class DeliveryDto {
    @Length(min = 10, max= 100)
    private String address;
    @NotNull
    @Pattern(regexp = "[A-Z]{1}[a-z]* [A-Z]{1}[a-z]*")
//    @Digits(integer = 10, fraction = 2)
    private String fullName;
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
