package com.example.demo1.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {

    private int id;
    private String name;
    private int price;
    private int stock;
    private String description;

}
