package com.example.demo1.controller.api;

import com.example.demo1.model.dto.ShoppingCartDto;
import com.example.demo1.model.dto.ShoppingCartReturnDto;
import com.example.demo1.model.dto.ShoppingCartUpdateDto;
import com.example.demo1.service.ShoppingCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/shopping-cart")
@RequiredArgsConstructor
public class ShoppingCartApiController {
    private final ShoppingCartService shoppingCartService;
    //create ShoppingCart
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createShoppingCart(@RequestBody ShoppingCartDto shoppingCartDto){
        shoppingCartService.create(shoppingCartDto);
    }

    //read ShoppingCart
    @GetMapping
    public List<ShoppingCartReturnDto> getShoppingCart(){
        return shoppingCartService.findAll();
    }

    @GetMapping("/description/{description}")
    public List<ShoppingCartReturnDto> getShoppingCartByDescription
                (@PathVariable("description") String description){
        return shoppingCartService.findByDescriptionProduct(description);
    }

    @GetMapping("/native-description/{description}")
    public List<ShoppingCartReturnDto> getShoppingCartByNativeDescription
            (@PathVariable("description") String description){
        return shoppingCartService.findByDescriptionProductNative(description);
    }

    @GetMapping("/hybrid-description/{description}")
    public List<ShoppingCartReturnDto> getShoppingCartByHybridDescription
            (@PathVariable String description){
        return shoppingCartService.findByDescriptionProductHybrid(description);
    }

    @GetMapping("/unit-price/{unitPrice}")
    public List<ShoppingCartReturnDto> getShoppingCartByUnitPrice
            (@PathVariable("unitPrice") Double unitPrice){
        return shoppingCartService.findByUnitPrice(unitPrice);
    }

    @GetMapping("/delivery-date/{dateOfDelivery}")
    public List<ShoppingCartReturnDto> getShoppingCartByDateOfDelivery
            (@PathVariable("dateOfDelivery") LocalDate dateOfDelivery){
        return shoppingCartService.findByDeliveryDate(dateOfDelivery);
    }

    //update ShoppingCart
    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateShoppingCart(@RequestBody ShoppingCartUpdateDto shoppingCartUpdateDto){
        shoppingCartService.update(shoppingCartUpdateDto);
    }

    //delete ShoppingCart
    @DeleteMapping("/{id}")
    public void deleteShoppingCart(@PathVariable Integer id){
        shoppingCartService.deleteShoppingCart(id);
    }
}
