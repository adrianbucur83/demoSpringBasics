package com.example.demo1.model;

import lombok.*;

@Data
@Builder
public class Car {
    private String model;
    private Engine engine;
    private String color;
    private String topSpeed;
    private Integer seats;
    private String transmission;
    private String brand;
    private Integer year;

}
