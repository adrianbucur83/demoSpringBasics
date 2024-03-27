package com.example.demo1.service.impl;

import com.example.demo1.config.AppSettings;
import com.example.demo1.model.Car;
import com.example.demo1.model.impl.DieselEngine;
import com.example.demo1.model.impl.ElectricEngine;
import com.example.demo1.model.impl.PetrolEngine;
import com.example.demo1.service.CarService;
import com.example.demo1.util.CarValidator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private final CarValidator carValidator;

    @Value("${numbers.separator}")
    Character separator;

    @Value("${language}")
    String language;

    @Value("${service.version}")
    private String serviceVersion;

    private final AppSettings appSettings;
    List<Car> cars = new ArrayList<>();

    public CarServiceImpl(CarValidator carValidator, AppSettings appSettings) {
        this.carValidator = carValidator;
        this.appSettings = appSettings;
    }

    public String getAllCars() {
        StringBuilder output = new StringBuilder();

        Car mercedes = Car.builder()
                .seats(4)
                .year(1984)
                .transmission("automatic")
                .topSpeed("100")
                .brand("Mercedes")
                .engine(new DieselEngine())
                .model("C200")
                .color("blue")
                .build();

        if (carValidator.validateCar(mercedes)) {
            cars.add(mercedes);
        }


        for (Car car : cars) {
            output.append(car.getModel())
                    .append(" ")
                    .append(car.getEngine())
                    .append("<br>")
                    .append("<br>")
                    .append("You are using service version: ")
                    .append(serviceVersion)
                    .append("<br>")
                    .append("Current country is: ")
                    .append(language)
                    .append("<br>")
                    .append("Number separator is: ")
                    .append(separator)
                    .append("<br>")
                    .append("Global settings are: ")
                    .append(appSettings.toString());

        }
        return output.toString();
    }
}
