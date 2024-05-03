package com.example.demo1.controller;

import com.example.demo1.model.dto.DeliveryDto;
import com.example.demo1.model.dto.DeliveryReturnDto;
import com.example.demo1.model.dto.DeliveryUpdateDto;
import com.example.demo1.service.DeliveriesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/deliveries")
@RequiredArgsConstructor
public class DeliveriesController {

    private final DeliveriesService deliveriesService;

    @GetMapping
    public String getDeliveries(Model model){
       List<DeliveryReturnDto> deliveries = deliveriesService.findAll();
       model.addAttribute("deliveries",deliveries);
       model.addAttribute("deliveryDto", new DeliveryDto());
        return "deliveries/deliveries";
    }

    @PostMapping
    public String createDelivery(@ModelAttribute("deliveryDto") @Valid DeliveryDto deliveryDto,
                                 BindingResult bindingResult,
                                 Model model) {
        model.addAttribute("deliveryDto", new DeliveryDto());
        deliveriesService.create(deliveryDto);
        return "redirect:/deliveries";
    }

    @GetMapping("/update-form/{id}")
    public String updateDeliveryForm(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("oldDelivery", deliveriesService.findById(id));
        model.addAttribute("deliveryUpdateDto", new DeliveryUpdateDto());
        return "deliveries/updateForm";
    }

    @PostMapping("/update")
    public String updateDelivery(@ModelAttribute @Valid DeliveryUpdateDto deliveryUpdateDto, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            model.addAttribute("oldDelivery", deliveriesService.findById(deliveryUpdateDto.getId()));
            return "deliveries/updateForm";
        }
        deliveriesService.update(deliveryUpdateDto);
        return "redirect:/deliveries";
    }

    @GetMapping("/delete/{id}")
    public String deleteDelivery(@PathVariable("id") Integer id){
        deliveriesService.deleteDelivery(id);
        return "redirect:/deliveries";
    }

}
