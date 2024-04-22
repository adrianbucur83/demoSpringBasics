package com.example.demo1.service;

import com.example.demo1.exception.BusinessException;
import com.example.demo1.model.Delivery;
import com.example.demo1.model.dto.DeliveryDto;
import com.example.demo1.model.dto.DeliveryReturnDto;
import com.example.demo1.model.dto.DeliveryUpdateDto;
import com.example.demo1.repository.DeliveriesRepository;
import com.example.demo1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DeliveriesService {

    private final DeliveriesRepository deliveriesRepository;
    private final UserRepository userRepository;

    public void create(DeliveryDto deliveryDto) {
        if (!deliveryDto.isConfirmed()) {
            throw new RuntimeException("Can't save a delivery that is not confirmed");
        }
        if (deliveryDto.getDate().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Wrong delivery date");
        }
        Delivery delivery = deliveryDto.toObject(deliveryDto);
        delivery.setUser(userRepository.findById(1).get());
        deliveriesRepository.save(delivery);
    }

    public List<DeliveryReturnDto> findAll() {
        return deliveriesRepository
                .findAll()
                .stream()
                .map(DeliveryReturnDto::toDto)
                .toList();
    }

    public List<DeliveryReturnDto> findAllOldJava() {
        List<Delivery> deliveries = deliveriesRepository.findAll();
        List<DeliveryReturnDto> deliveryReturnDtos = new ArrayList<>();
        for (Delivery delivery : deliveries) {
            DeliveryReturnDto deliveryReturnDto = DeliveryReturnDto.toDto(delivery);
            deliveryReturnDtos.add(deliveryReturnDto);
        }
        return deliveryReturnDtos;
    }

    public Delivery findById(Integer id) {
        return deliveriesRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Delivery not found for id: " + id));
    }

    public void update(DeliveryUpdateDto deliveryDto) {
        Delivery delivery = findById(deliveryDto.getId());
        delivery.setDate(deliveryDto.getDate());
        delivery.setAddress(deliveryDto.getAddress());
        delivery.setConfirmed(deliveryDto.isConfirmed());
        deliveriesRepository.save(delivery);
    }

    public void deleteDelivery(Integer id) {
        findById(id);
        deliveriesRepository.deleteById(id);
    }

    public List<DeliveryReturnDto> findAllByAddress(String address) throws Exception{
        List<DeliveryReturnDto> deliveries = deliveriesRepository.findAllByAddress(address)
                .stream()
                .map(DeliveryReturnDto::toDto)
                .toList();
        if (deliveries.isEmpty()) {
            throw new BusinessException("Address not found:" + address);
        }
        return deliveries;

    }
}
