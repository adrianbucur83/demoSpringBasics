package com.example.demo1.controller;

import com.example.demo1.model.Order;
import com.example.demo1.model.WelcomeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    WelcomeMessage welcomeMessage;
    List<Order> orders = new ArrayList<>();
     {
        Order order1 = new Order(1l, "Denis Bulat", 100l);
        Order order2 = new Order(2l, "Natalia Dolghieru", 100l);
        orders.add(order1);
        orders.add(order2);
    }

    public Order createOrder(Order order){
        order.setOrderId(order.getOrderId());
        order.setCustomerName(order.getCustomerName());
        order.setTotalAmount(order.getTotalAmount());
//        order.setNotes(order.getNotes());
//        order.setOrderStatus(order.getOrderStatus());
//        order.setDateTime(order.getDateTime());
//        order.setBillingAddress(order.getBillingAddress());
//        order.setPaymentMethod(order.getPaymentMethod());
//        order.setPaymentStatus(order.getPaymentStatus());
//        order.setShippingAddress(order.getShippingAddress());
//        order.setShippingStatus(order.getShippingStatus());
     return order;
     }
    public Order updateOrder(Order order){

        order.setOrderId(order.getOrderId());
        order.setCustomerName(order.getCustomerName());
        order.setTotalAmount(order.getTotalAmount());

        return order;
    }
    @GetMapping
    public String createOrder(Model model){
        model.addAttribute("orders", orders);
        return "orders/order";
    }
    @GetMapping("/new")
    public String getOrder(Model model){
        Order order = new Order();
        model.addAttribute("order", order);
        return "orders/create-order";
    }
    @PostMapping
    public String createOrders(@ModelAttribute("order") Order order){
        createOrder(order);
        orders.add(order);
        return "redirect:/orders";
    }
    @GetMapping("/{orderId}/edit")
    public String editOrder(@PathVariable("orderId") Long orderId , Model model) {
//        Order order = orders.stream()
//                            .filter(o -> o.getOrderId().equals(orderId))
//                            .findFirst()
//                            .orElse(null);
//        model.addAttribute("order", order);
        Order orderToEdit = null;
        for (Order order : orders) {
            if (order.getOrderId().equals(orderId)) {
                orderToEdit = order;
                break; // Exit loop once the desired order is found
            }
        }

        if (orderToEdit != null) {
            model.addAttribute("order", orderToEdit);
        }
        return "orders/edit-order";

    }
    @PostMapping("/{orderId}")
    public String updateOrders(@PathVariable Long orderId,
                               @ModelAttribute("order") Order order){
        for (Order order1 : orders){
            if(order1.getOrderId().equals(orderId)){
                order1.setOrderId(order.getOrderId());
                order1.setTotalAmount(order.getTotalAmount());
                order1.setCustomerName(order.getCustomerName());
            }
        }
        return "redirect:/orders";
    }

    @GetMapping("/{orderId}/delete")
    public String deleteOrder(@PathVariable("orderId")Long orderId) {
        Iterator<Order> iterator = orders.iterator();
        while (iterator.hasNext()){
            Order order1 = iterator.next();
            if (order1.getOrderId().equals(orderId)){
                iterator.remove();
                break;
            }
        }
        return "redirect:/orders";
    }
    @GetMapping("/{orderId}/view")
    public String viewOrder(@PathVariable("orderId")Long orderId, Model model) {

         Order orderToView = null;
         for (Order order: orders){
             if (order.getOrderId().equals(orderId)){
                 orderToView = order;
                 break;
             }
         }
         model.addAttribute("order", orderToView);

        return "orders/view-order";
    }
}
