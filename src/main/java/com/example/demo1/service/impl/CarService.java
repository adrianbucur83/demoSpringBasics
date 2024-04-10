//package com.example.demo1.service.impl;
//
//import com.example.demo1.config.AppSettings;
//import com.example.demo1.model.Car;
//import com.example.demo1.model.impl.DieselEngine;
//import com.example.demo1.model.impl.ElectricEngine;
//import com.example.demo1.util.CarValidator;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class CarService {
//    private final CarValidator carValidator;
//
//    @Value("${numbers.separator}")
//    Character separator;
//
//    @Value("${language}")
//    String language;
//
//    @Value("${service.version}")
//    private String serviceVersion;
//
//    private final AppSettings appSettings;
//    List<Car> cars = new ArrayList<>();
//
//    public CarService(CarValidator carValidator, AppSettings appSettings) {
//        this.carValidator = carValidator;
//        this.appSettings = appSettings;
//    }
//
//    public List<Car> getAllCars() {
//        List<Car> cars = new ArrayList<>();
//
//        Car mercedes = Car.builder()
//                .seats(4)
//                .year(1984)
//                .transmission("automatic")
//                .topSpeed("100")
//                .brand("Mercedes")
//                .engine(new DieselEngine())
//                .model("C200")
//                .color("blue")
//                .build();
//
//        Car audi = Car.builder()
//                .seats(4)
//                .year(2020)
//                .transmission("automatic")
//                .topSpeed("200")
//                .brand("Audi")
//                .engine(new ElectricEngine())
//                .model("A4")
//                .color("red")
//                .build();
//
//        cars.add(mercedes);
//        cars.add(audi);
//
//        return cars;
//    }
//}
