package com.example.demo1.model;


import org.springframework.beans.factory.annotation.Lookup;

public class WelcomeMessage {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public WelcomeMessage(String message) {
        this.message = message;
    }


}
