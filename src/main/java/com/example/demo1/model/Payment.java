package com.example.demo1.model;

import lombok.*;

@Data
@Builder
public class Payment {
    private String orderNumber;
    private String invoiceNumber;
    private double invoiceValue;
    private String status;
}
