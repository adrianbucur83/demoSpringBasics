package com.example.demo1.model.dto;

import com.example.demo1.model.Delivery;
import lombok.Data;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Data
public class DeliveryReturnDto {
    private Integer id;
    private String address;
    private String date;
    private boolean confirmed;
    private UserReturnDto user;
    private List<ProductReturnDto> products;

    public static DeliveryReturnDto toDto(Delivery delivery) {
        DeliveryReturnDto deliveryDto = new DeliveryReturnDto();
        deliveryDto.setAddress(delivery.getAddress());
        deliveryDto.setConfirmed(delivery.isConfirmed());
        String europeanDatePattern = "dd.MM.yyyy hh:mm";
        DateTimeFormatter europeanDateFormatter = DateTimeFormatter.ofPattern(europeanDatePattern);
        deliveryDto.setDate(europeanDateFormatter.format(delivery.getDate()));
        deliveryDto.setId(delivery.getId());
        deliveryDto.setUser(
                new UserReturnDto(delivery.getUser().getFirstName(), delivery.getUser().getLastName(), 7));
        List<ProductReturnDto> productReturnDtoList = delivery.getProducts().stream()
                .map(product -> new ProductReturnDto(product.getName(), product.getPrice(), product.getStock(), product.getDescription()))
                .toList();
        deliveryDto.setProducts(productReturnDtoList);
        return deliveryDto;
    }

    //        BeanUtils.copyProperties(delivery, deliveryDto);

}
