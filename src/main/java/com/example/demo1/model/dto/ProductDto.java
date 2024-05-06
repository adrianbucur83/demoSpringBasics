package com.example.demo1.model.dto;

import com.example.demo1.model.Product;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDto {

    @NotNull
    private String name;
    @NotNull
    private int price;
    @NotNull
    @PositiveOrZero
    private int stock;
    private String description;

    public Product toObject(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());
        product.setDescription(productDto.getDescription());
        return product;
    }

}
