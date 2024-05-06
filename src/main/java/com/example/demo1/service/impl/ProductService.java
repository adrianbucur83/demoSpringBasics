package com.example.demo1.service.impl;

import com.example.demo1.model.Product;
import com.example.demo1.model.dto.ProductDto;
import com.example.demo1.repository.ProductsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {

    public ProductsRepository productsRepository;

    public void createProduct(ProductDto productDto) {
        if(productsRepository.findByName(productDto.getName()) == null) {
            throw new RuntimeException("A product with this name already exists!");
        }
        Product product = productDto.toObject(productDto);
        productsRepository.save(product);
    }

    public void updateProduct(Integer productId, ProductDto productDto) {
        Product product = findById(productId);

        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());
        product.setDescription(productDto.getDescription());

        productsRepository.save(product);
    }

    public void deleteProduct(Integer productId) {
        findById(productId);
        productsRepository.deleteById(productId);
    }

    public Product findById(Integer id) {
        return productsRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

}
