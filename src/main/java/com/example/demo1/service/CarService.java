package com.example.demo1.service;

import com.example.demo1.model.Car;
import com.example.demo1.model.impl.DieselEngine;
import com.example.demo1.model.impl.ElectricEngine;
import com.example.demo1.model.impl.PetrolEngine;
import com.example.demo1.util.CarValidator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface CarService {
    public String getAllCars() ;
}
