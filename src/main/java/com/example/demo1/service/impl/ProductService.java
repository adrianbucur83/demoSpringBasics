package com.example.demo1.service.impl;

import com.example.demo1.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {

    public static Map<Integer, Product> productHashMap = new HashMap<>();

    public Product getProductById(int id) {
        return productHashMap.get(id);
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(productHashMap.values());
    }

    public void createProduct(Product product) {
        productHashMap.put(product.getId(), product);
    }

    public void updateProduct(Product oldProduct, Product newProduct) {
        productHashMap.remove(oldProduct.getId());
        productHashMap.put(newProduct.getId(), newProduct);
    }

    public void deleteById(int id) {
        productHashMap.remove(id);
    }

    public boolean productExists(int id) {
        if(productHashMap.get(id) != null)
            return true;

        return false;
    }

}
