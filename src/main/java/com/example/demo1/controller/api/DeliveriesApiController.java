package com.example.demo1.controller.api;

import com.example.demo1.exception.BusinessException;
import com.example.demo1.model.dto.DeliveryDto;
import com.example.demo1.model.dto.DeliveryReturnDto;
import com.example.demo1.model.dto.DeliveryUpdateDto;
import com.example.demo1.service.DeliveriesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deliveries")
@RequiredArgsConstructor
@Validated
public class DeliveriesApiController {

    private final DeliveriesService deliveriesService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createDelivery(@RequestBody @Valid DeliveryDto deliveriesCreateDto){
        deliveriesService.create(deliveriesCreateDto);
    }

    @GetMapping
    public List<DeliveryReturnDto> getDeliveries(){
        return deliveriesService.findAll();
    }

    @GetMapping("/address/{address}")
    public List<DeliveryReturnDto> getDeliveriesByAddress(@PathVariable("address") String address){
        try {
            return deliveriesService.findAllByAddress(address);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage(), e);
        }
    }


    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateDelivery(@RequestBody DeliveryUpdateDto deliveryDto){
        deliveriesService.update(deliveryDto);
    };

    @DeleteMapping("/{id}")
    public void deleteDelivery(@PathVariable Integer id){
        deliveriesService.deleteDelivery(id);
    }

}
