package com.example.demo1.controller;

import com.example.demo1.model.WelcomeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeliveriesController {
    @Autowired
    WelcomeMessage welcomeMessage;

    @GetMapping("/deliveries")
    public String getDeliveries() {
        return welcomeMessage.getMessage() + "<br> Delivery 1 <br> Delivery 2";
    }

    @GetMapping("/deliveries/{name}")
    public String getDeliveries(@PathVariable("name") String name) {
        return welcomeMessage.getMessage() + name + "<br> Delivery 1 <br> Delivery 2";
    }

}
