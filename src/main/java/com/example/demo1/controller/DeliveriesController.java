package com.example.demo1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/deliveries")
public class DeliveriesController {

    //CRUD
    @PostMapping
    public String createDelivery(){
        return "deliveries/createDelivery";
    };

    @GetMapping
    public String getDeliveries(){
        return "deliveries/getDeliveries";
    };

    @PutMapping
    public String updateDelivery(){
        return "deliveries/updateDelivery";
    };

    @DeleteMapping
    public String deleteDelivery(){
        return "deliveries/deleteDelivery";
    };

}
