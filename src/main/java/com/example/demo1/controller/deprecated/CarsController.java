package com.example.demo1.controller.deprecated;

import com.example.demo1.model.Car;
import com.example.demo1.model.WelcomeMessage;
import com.example.demo1.service.impl.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller

@RequestMapping("/cars")
public class CarsController {
    private final WelcomeMessage welcomeMessage;
    private final CarService carService;

    @Autowired
    public CarsController(WelcomeMessage welcomeMessage, CarService carService) {
        this.carService = carService;
        this.welcomeMessage = welcomeMessage;
    }

    @GetMapping()
    public String getAllCars(
            @RequestParam(required = false) @ModelAttribute String goodbyeMessage,
            Model model) {
        model.addAttribute("goodbyeMessage", goodbyeMessage);
        model.addAttribute("welcomeMessage", welcomeMessage.getMessage());
        return "cars";
    }
    @ModelAttribute(name = "cars")
    private List<Car> getAllCars(){
        return  carService.getAllCars();
    }




    @RequestMapping(method = RequestMethod.GET, path = "/getAllByColor")
    @ResponseBody
    public ResponseEntity<String> getAllCars(Model model, @RequestParam(required = true) String color, @RequestParam String engine) {
        String result =  carService.getAllCars()
                .stream()
                .filter(car -> car.getColor().equalsIgnoreCase(color))
                .toList()
                .toString();
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public String deleteCarById(Model model) {
        model.addAttribute("cars", carService.getAllCars());
        model.addAttribute("welcomeMessage", welcomeMessage.getMessage());
//        carService.deleteAllCars();
        return "deleted all the cars";
    }


}
