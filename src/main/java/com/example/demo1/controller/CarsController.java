package com.example.demo1.controller;

import com.example.demo1.model.WelcomeMessage;
import com.example.demo1.service.impl.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/car")
public class CarsController {
    private final WelcomeMessage welcomeMessage;
    private final CarService carService;

    @Autowired
    public CarsController(WelcomeMessage welcomeMessage, CarService carService) {
        this.carService = carService;
        this.welcomeMessage = welcomeMessage;
    }

    @GetMapping("/getAll")
    public String getAllCars(Model model) {
        model.addAttribute("cars", carService.getAllCars());
        model.addAttribute("welcomeMessage", welcomeMessage.getMessage());
        return "cars";
    }

    //    @GetMapping(path = "/get/{id}/{color}/{year}")
    @RequestMapping(method = RequestMethod.GET, path = "/getAllByColor")
    @ResponseBody
    public String getAllCars(Model model, @RequestParam(required = true) String color, @RequestParam String engine) {
        return carService.getAllCars()
                .stream()
                .filter(car -> car.getColor().equalsIgnoreCase(color))
                .toList()
                .toString();
    }

    @DeleteMapping("/deleteAll")
    @ResponseBody
    public String deleteAllCars(Model model) {
        model.addAttribute("cars", carService.getAllCars());
        model.addAttribute("welcomeMessage", welcomeMessage.getMessage());
//        carService.deleteAllCars();
        return "deleted all the cars";
    }


}
