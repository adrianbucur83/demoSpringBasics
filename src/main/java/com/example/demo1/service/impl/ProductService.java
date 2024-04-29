package com.example.demo1.service.impl;

import com.example.demo1.model.Product;
import com.example.demo1.repository.ProductsRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    public ProductsRepository productsRepository;

    public ProductService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public void createProduct(Product product) {
        if(!productExists(product.getId())) {
            productsRepository.save(product);
        } else {
            throw new RuntimeException("Product already exists!");
        }
    }

    public void updateProduct(Product oldProduct, Product newProduct) {
        newProduct.setId(oldProduct.getId());
        newProduct.setName(oldProduct.getName());
        newProduct.setPrice(oldProduct.getPrice());
        newProduct.setStock(oldProduct.getStock());
        newProduct.setDescription(oldProduct.getDescription());

        productsRepository.save(newProduct);
    }

    public boolean productExists(int productId) {
        return productsRepository.findById(productId) != null;
    }

}
