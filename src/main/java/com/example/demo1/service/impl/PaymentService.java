package com.example.demo1.service.impl;

import com.example.demo1.model.Payment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PaymentService {
    List<Payment> paymentList = new ArrayList<>();

    public List<Payment> getAllPayments() {
        return paymentList;

    }

    Payment payment = Payment.builder()
            .orderNumber("478960")
            .invoiceNumber("F750")
            .invoiceValue(7454)
            .status("achitata")
            .build();

    public List<Payment> addPayment() {

        paymentList.add(payment);
        return paymentList;
    }

    public List<Payment> modifyPayment() {
        Payment newPayment = Payment.builder()
                .orderNumber("478961")
                .invoiceNumber("F751")
                .invoiceValue(35)
                .status("neachitata")
                .build();

        return paymentList;
    }

    public List<Payment> deletePayment() {
        paymentList.remove(payment);
        return paymentList;
    }
}

