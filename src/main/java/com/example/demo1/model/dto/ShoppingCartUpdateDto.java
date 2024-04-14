package com.example.demo1.model.dto;

import com.example.demo1.model.ShoppingCart;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ShoppingCartUpdateDto {
    private Integer Id;
    private Integer productId;
    private String descriptionProduct;
    private Double unitPrice;
    private boolean availability;
    private LocalDate dateOfDelivery;
    private Integer customerId;


    public ShoppingCart toObject(ShoppingCartUpdateDto shoppingCartUpdateDto){
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId(shoppingCartUpdateDto.getId());
        shoppingCart.setDescriptionProduct(shoppingCartUpdateDto.getDescriptionProduct());
        shoppingCart.setUnitPrice(shoppingCartUpdateDto.getUnitPrice());
        shoppingCart.setDateOfDelivery(shoppingCartUpdateDto.getDateOfDelivery());
        shoppingCart.setAvailability(shoppingCartUpdateDto.isAvailability());
        shoppingCart.setCustomerId(shoppingCartUpdateDto.getCustomerId());
        shoppingCart.setProductId(shoppingCartUpdateDto.getProductId());
        return shoppingCart;
    }
    public static ShoppingCartUpdateDto toDto(ShoppingCart shoppingCart){
        ShoppingCartUpdateDto shoppingCartDto = new ShoppingCartUpdateDto();
        shoppingCartDto.setId(shoppingCart.getId());
        shoppingCartDto.setDescriptionProduct(shoppingCart.getDescriptionProduct());
        shoppingCartDto.setUnitPrice(shoppingCart.getUnitPrice());
        shoppingCartDto.setDateOfDelivery(shoppingCart.getDateOfDelivery());
        shoppingCartDto.setAvailability(shoppingCart.isAvailability());
        shoppingCartDto.setId(shoppingCart.getId());
        shoppingCartDto.setCustomerId(shoppingCart.getCustomerId());
        shoppingCartDto.setProductId(shoppingCart.getProductId());
        return shoppingCartDto;
    }

}
