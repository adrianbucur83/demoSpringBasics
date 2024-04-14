package com.example.demo1.service;

import com.example.demo1.model.ShoppingCart;
import com.example.demo1.model.dto.ShoppingCartDto;
import com.example.demo1.model.dto.ShoppingCartReturnDto;
import com.example.demo1.model.dto.ShoppingCartUpdateDto;
import com.example.demo1.repository.ShoppingCartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    public void create(ShoppingCartDto shoppingCartDto){
        if (!shoppingCartDto.isAvailability())
        {
            throw new RuntimeException("Delivery is not available");
        }
        if (shoppingCartDto.getDateOfDelivery().isBefore(LocalDate.now()))
        {
            throw new RuntimeException("Delivery cannot be made on date specified");
        }
        if (shoppingCartDto.getDescriptionProduct().length()<1)
        {
            throw new RuntimeException("Description product unspecified");
        }
        if (shoppingCartDto.getProductId()==null)
        {
            throw new RuntimeException("Product unspecified");
        }
        if (shoppingCartDto.getCustomerId()==null)
        {
            throw new RuntimeException("Customer unspecified");
        }

        shoppingCartRepository.save(shoppingCartDto.toObject(shoppingCartDto));
    }

    public List<ShoppingCartReturnDto> findAll(){
        return shoppingCartRepository
                .findAll()
                .stream()
                .map(ShoppingCartReturnDto::toDto)
                .toList();
    }

    List<ShoppingCartReturnDto> findAllOldJava() {
        List<ShoppingCart> shoppingCarts = shoppingCartRepository.findAll();
        List<ShoppingCartReturnDto> shoppingCartReturnDto =  new ArrayList<>();
        for(ShoppingCart shoppingCart: shoppingCarts){
            ShoppingCartReturnDto shoppingCartReturnDto1 = ShoppingCartReturnDto.toDto(shoppingCart);
            shoppingCartReturnDto.add(shoppingCartReturnDto1);
        }
        return shoppingCartReturnDto;

    }



    public ShoppingCart findById(Integer id){
        return shoppingCartRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Delivery not found "+id));
    }

    public void update(ShoppingCartUpdateDto shoppingCartUpdateDto){
        ShoppingCart shoppingCart = findById(shoppingCartUpdateDto.getId());
        shoppingCart.setDateOfDelivery(shoppingCartUpdateDto.getDateOfDelivery());
        shoppingCart.setDescriptionProduct(shoppingCartUpdateDto.getDescriptionProduct());
        shoppingCart.setAvailability(shoppingCartUpdateDto.isAvailability());
        shoppingCart.setCustomerId(shoppingCartUpdateDto.getCustomerId());
        shoppingCart.setProductId(shoppingCartUpdateDto.getProductId());
        shoppingCart.setUnitPrice(shoppingCartUpdateDto.getUnitPrice());
        shoppingCartRepository.save(shoppingCart);
    }

    /*public ShoppingCart delete(ShoppingCart shoppingCart){
        ShoppingCart shoppingCartDeleted = findById(shoppingCart.getId());
        shoppingCartRepository.delete(shoppingCartDeleted);
        return shoppingCartDeleted;
    }*/

    public void deleteShoppingCart(Integer id){
       findById(id);
       shoppingCartRepository.deleteById(id);
    }

    public List<ShoppingCartReturnDto> findByDescriptionProduct(String description) {
        return shoppingCartRepository.findByDescriptionProduct(description)
                .stream()
                .map(ShoppingCartReturnDto::toDto)
                .toList();
    }

    public List<ShoppingCartReturnDto> findByUnitPrice(Double unitPrice) {
        return shoppingCartRepository.findByUnitPrice(unitPrice)
                .stream()
                .map(ShoppingCartReturnDto::toDto)
                .toList();
    }

    public List<ShoppingCartReturnDto> findByDescriptionProductNative(String description) {
        return shoppingCartRepository.findByDescriptionProductNative(description)
                .stream()
                .map(ShoppingCartReturnDto::toDto)
                .toList();
    }

    public List<ShoppingCartReturnDto> findByDescriptionProductHybrid(String description){
        return shoppingCartRepository
                .findByDescriptionProductHybrid(description)
                .stream()
                .map(ShoppingCartReturnDto::toDto)
                .toList();
    }

    public List<ShoppingCartReturnDto> findByDeliveryDate(LocalDate deliveryDate){
        return shoppingCartRepository
                .findByDeliveryDate(deliveryDate)
                .stream()
                .map(ShoppingCartReturnDto::toDto)
                .toList();
    }

}
