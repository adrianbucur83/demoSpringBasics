package com.example.demo1.model;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@SuperBuilder
public abstract class Notification {

    protected int id;
    protected String message;
    protected Date timestamp;

}
