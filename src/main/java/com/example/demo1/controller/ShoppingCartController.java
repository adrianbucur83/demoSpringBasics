package com.example.demo1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/shopping-cart")
public class ShoppingCartController {
    //create ShoppingCart
    @PostMapping
    public String createShoppingCart(){
        return "shopping-cart/shopping-carts";
    }

    //read ShoppingCart
    @GetMapping
    public String getShoppingCart(Model model){
        model.addAttribute("shopping-carts", null);
        return "shopping-cart/shopping-carts";
    }

    //update ShoppingCart
    @PutMapping
    public String putShoppingCart(){
        return "shopping-cart/shopping-carts";
    }

    //delete ShoppingCart
    @DeleteMapping
    public String deleteShoppingCart(){
        return "shopping-cart/shopping-carts";
    }
}
