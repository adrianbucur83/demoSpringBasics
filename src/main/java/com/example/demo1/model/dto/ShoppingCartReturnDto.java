package com.example.demo1.model.dto;

import com.example.demo1.model.ShoppingCart;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ShoppingCartReturnDto {
    private Integer Id;
    private String descriptionProduct;
    private Double unitPrice;
    private boolean availability;
    private LocalDate dateOfDelivery;


    public ShoppingCart toObject(ShoppingCartReturnDto shoppingCartDto){
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId(shoppingCartDto.getId());
        shoppingCart.setDescriptionProduct(shoppingCartDto.getDescriptionProduct());
        shoppingCart.setUnitPrice(shoppingCartDto.getUnitPrice());
        shoppingCart.setDateOfDelivery(shoppingCartDto.getDateOfDelivery());
        shoppingCart.setAvailability(shoppingCartDto.isAvailability());
        return shoppingCart;
    }
    public static ShoppingCartReturnDto toDto(ShoppingCart shoppingCart){
        ShoppingCartReturnDto shoppingCartDto = new ShoppingCartReturnDto();
        shoppingCartDto.setId(shoppingCart.getId());
        shoppingCartDto.setDescriptionProduct(shoppingCart.getDescriptionProduct());
        shoppingCartDto.setUnitPrice(shoppingCart.getUnitPrice());
        shoppingCartDto.setDateOfDelivery(shoppingCart.getDateOfDelivery());
        shoppingCartDto.setAvailability(shoppingCart.isAvailability());
        return shoppingCartDto;
    }

}
