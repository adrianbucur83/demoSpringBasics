package com.example.demo1.controller;

import com.example.demo1.model.dto.DeliveryReturnDto;
import com.example.demo1.service.DeliveriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/deliveries")
@RequiredArgsConstructor
public class DeliveriesController {

    private final DeliveriesService deliveriesService;

    //CRUD
    @PostMapping
    public String createDelivery(){
        return "deliveries/createDelivery";
    };

    @GetMapping
    public String getDeliveries(Model model){
       List<DeliveryReturnDto> deliveries = deliveriesService.findAll();
       model.addAttribute("deliveries",deliveries);

        return "deliveries/deliveries";
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
