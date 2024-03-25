package com.example.demo1.model.impl;

import com.example.demo1.model.Engine;

public class ElectricEngine implements Engine {
    @Override
    public String start() {
        return "Electric engine on, waiting instructions";
    }
}
