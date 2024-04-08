package com.example.demo1.service.impl;

import com.example.demo1.model.Delivery;
import com.example.demo1.repository.DeliveriesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeliveriesService {

    private final DeliveriesRepository deliveriesRepository;
    public Delivery create(Delivery delivery) {
        return deliveriesRepository.save(delivery);
    }

    public List<Delivery> findAll() {
        return deliveriesRepository.findAll();
    }

    public Delivery findById(Integer id) {
        return deliveriesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Delivery not found for id: " + id));
    }

    public Delivery update(Delivery delivery) {
        Delivery deliveryToUpdate = findById(delivery.getId());
        deliveryToUpdate.setAddress(delivery.getAddress());
        return deliveriesRepository.save(delivery);
    }

    public void deleteDelivery(Integer id) {
         deliveriesRepository.deleteById(id);
    }

}
