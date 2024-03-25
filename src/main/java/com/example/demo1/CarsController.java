package com.example.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CarsController {

    public CarsController(WelcomeMessage welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }
    WelcomeMessage welcomeMessage;
    List<Car> cars = new ArrayList<>();

    @GetMapping("/car")
    public String getAllCars() {
        String output = "";

        Car mercedes = new Car("Mercedes CLS", new DieselEngine());
        cars.add(mercedes);

        Car daciaSpring = new Car("Dacia Spring", new ElectricEngine());
        Car loganPetrol = new Car("Logan Petrol", new PetrolEngine());
        cars.add(daciaSpring);
        cars.add(loganPetrol);
        for (Car car : cars) {
            output += car.getModel() + " " + car.startEngine() + "<br>";
        }
        return welcomeMessage.getMessage() + "<br> Car list <br> " + output;
    }

}
