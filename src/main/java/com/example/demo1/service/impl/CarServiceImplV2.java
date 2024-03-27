package com.example.demo1.service.impl;

import com.example.demo1.model.Car;
import com.example.demo1.model.impl.DieselEngine;
import com.example.demo1.model.impl.ElectricEngine;
import com.example.demo1.model.impl.PetrolEngine;
import com.example.demo1.service.CarService;
import com.example.demo1.util.CarValidator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CarServiceImplV2 implements CarService {
    private final CarValidator carValidator;
    List<Car> cars = new ArrayList<>();

    public CarServiceImplV2(CarValidator carValidator) {
        this.carValidator = carValidator;
    }
    public String getAllCars() {

        return "Car service v2";
    }
}
