package com.example.demo1;

public class Car {
    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                '}';
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
    }

    public Car(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    private String model;

    private Engine engine;
    public String startEngine() {
        return engine.start();
    }

}
