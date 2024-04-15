package com.example.demo1;

import com.example.demo1.model.Product;
import com.example.demo1.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CreateProductsAtStart {

    @Autowired
    ProductService productService;

    @EventListener(ApplicationReadyEvent.class)
    public void createProducts() {
        Product keyboard = Product.builder().id(1).name("Keyboard").price(1000).stock(10).description("A board with keys!").build();
        productService.createProduct(keyboard);

        Product mouse = Product.builder().id(2).name("Mouse").price(100).stock(20).description("A device that moves your cursor!").build();
        productService.createProduct(mouse);

        Product gpu = Product.builder().id(3).name("Graphics Card").price(400).stock(3).description("A device that outputs signal to a display!").build();
        productService.createProduct(gpu);
    }
}
