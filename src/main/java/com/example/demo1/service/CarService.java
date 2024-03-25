package com.example.demo1.service;

import com.example.demo1.model.Car;
import com.example.demo1.model.impl.DieselEngine;
import com.example.demo1.model.impl.ElectricEngine;
import com.example.demo1.model.impl.PetrolEngine;
import com.example.demo1.util.CarValidator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    private final CarValidator carValidator;
    List<Car> cars = new ArrayList<>();

    public CarService(CarValidator carValidator) {
        this.carValidator = carValidator;
    }

    public String getAllCars() {
        StringBuilder output = new StringBuilder();

        Car mercedes = new Car("", new DieselEngine());
        if (carValidator.validateCar(mercedes)) {
            cars.add(mercedes);
        }
        Car daciaSpring = new Car("Dacia Spring", new ElectricEngine());
        Car loganPetrol = new Car("Logan Petrol", new PetrolEngine());
        cars.add(daciaSpring);
        cars.add(loganPetrol);
        for (Car car : cars) {
            output.append(car.getModel()).append(" ").append(car.startEngine()).append("<br>");
        }
        return output.toString();
    }

}
