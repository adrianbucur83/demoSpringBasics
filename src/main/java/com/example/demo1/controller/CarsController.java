package com.example.demo1.controller;

import com.example.demo1.service.CarService;
import com.example.demo1.model.WelcomeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class CarsController {
    private final WelcomeMessage welcomeMessage;
    private final CarService carService;

    @Autowired
    public CarsController(WelcomeMessage welcomeMessage,
                          @Qualifier("carServiceImpl") CarService carService) {
        this.carService = carService;
        this.welcomeMessage = welcomeMessage;
    }

    @GetMapping("/car")
    public String getAllCars() {
        return welcomeMessage.getMessage() + "<br> Car list <br> " + carService.getAllCars();
    }

}
