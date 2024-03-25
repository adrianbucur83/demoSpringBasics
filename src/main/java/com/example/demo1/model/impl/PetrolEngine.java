package com.example.demo1.model.impl;

import com.example.demo1.model.Engine;

public class PetrolEngine implements Engine {
    @Override
    public String start() {
        return "starting petrol engine";
    }
}
