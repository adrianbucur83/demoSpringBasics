package com.example.demo1.util;

import com.example.demo1.model.Car;
import org.springframework.stereotype.Component;

@Component
public class CarValidator {
    public boolean validateCar(Car car) {
        return car.getModel() != null && !car.getModel().isEmpty();
    }
}
