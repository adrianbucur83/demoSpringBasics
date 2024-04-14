package com.example.demo1.model.dto;

import com.example.demo1.model.ShoppingCart;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ShoppingCartDto {
    private Integer productId;
    private String descriptionProduct;
    private Double unitPrice;
    private boolean availability;
    private LocalDate dateOfDelivery;
    private Integer customerId;

    public ShoppingCart toObject(ShoppingCartDto shoppingCartDto){
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setProductId(shoppingCartDto.getProductId());
        shoppingCart.setDescriptionProduct(shoppingCartDto.getDescriptionProduct());
        shoppingCart.setUnitPrice(shoppingCartDto.getUnitPrice());
        shoppingCart.setDateOfDelivery(shoppingCartDto.getDateOfDelivery());
        shoppingCart.setAvailability(shoppingCartDto.isAvailability());
        shoppingCart.setCustomerId(shoppingCartDto.getCustomerId());
        return shoppingCart;
    }
    public ShoppingCartDto toDto(ShoppingCart shoppingCart){
        ShoppingCartDto shoppingCartDto = new ShoppingCartDto();
        shoppingCartDto.setProductId(shoppingCart.getProductId());
        shoppingCartDto.setDescriptionProduct(shoppingCart.getDescriptionProduct());
        shoppingCartDto.setUnitPrice(shoppingCart.getUnitPrice());
        shoppingCartDto.setDateOfDelivery(shoppingCart.getDateOfDelivery());
        shoppingCartDto.setAvailability(shoppingCart.isAvailability());
        shoppingCartDto.setCustomerId(shoppingCart.getCustomerId());
        return shoppingCartDto;
    }

}
