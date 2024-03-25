package com.example.demo1.model.impl;

import com.example.demo1.model.Engine;

public class DieselEngine implements Engine {
    @Override
    public String start() {
        return "Diesel engine burning old dinosaurs";
    }
}
