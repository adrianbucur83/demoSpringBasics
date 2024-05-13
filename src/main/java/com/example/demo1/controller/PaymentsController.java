package com.example.demo1.controller;


import com.example.demo1.model.Payment;
import com.example.demo1.model.WelcomeMessage;
import com.example.demo1.service.impl.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/payment")
public class PaymentsController {
    private final WelcomeMessage welcomeMessagePayment;
    private final PaymentService paymentService;


    @Autowired

    public PaymentsController(WelcomeMessage welcomeMessagePayment, PaymentService paymentService) {
        this.welcomeMessagePayment = welcomeMessagePayment;
        this.paymentService = paymentService;

    }

    @GetMapping("/allPayments")
    public String getAllPayment(Model model) {
        model.addAttribute("payments", paymentService.getAllPayments());
        model.addAttribute("welcomeMessage", welcomeMessagePayment.getMessage());
        return "payments";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/addPayment")
    @ResponseBody
    public String addPayment(Model modelAdd) {
        modelAdd.addAttribute("addPayment", paymentService.addPayment());
        return "Payment added";
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/modifyPayment")
    @ResponseBody
    public String modifyPayment(Model modelModify) {
        modelModify.addAttribute("modifyPayment", paymentService.modifyPayment());
        return "Payment was modified";
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/deletePayment")
    @ResponseBody
    public String deletePayment(Model modelDelete) {
        modelDelete.addAttribute("deletePayment", paymentService.deletePayment());
        return "Payment was deleted";
    }

}
