package com.example.demo1.controller;

import com.example.demo1.model.Order;
import com.example.demo1.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderController {

    private OrderService orderService;

    @GetMapping
    public String getOrders(Model model){
        List<Order> orders = orderService.getAllOrders();
        model.addAttribute("orders", orders);
        return "orders/order";
    }

    @GetMapping("/new")
    public String createOrder(Model model){
        Order order = new Order();
        model.addAttribute("order", order);
        return "orders/create-order";
    }

    @PostMapping
    public String showOrders(@ModelAttribute("order") Order order){
        orderService.createOrder(order);
        return "redirect:/orders";
    }

    @GetMapping("/{orderId}/edit")
    public String editOrder(@PathVariable("orderId") Long orderId , Model model) {

        Order order = orderService.getOrderById(orderId);

        model.addAttribute("order", order);

        return "orders/edit-order";
    }

    @PostMapping("/{orderId}")
    public String updateOrders(@PathVariable Long orderId,
                               @ModelAttribute("order") Order order){
        order.setOrderId(orderId);
        orderService.updateOrder(order);
        return "redirect:/orders";
    }

    @GetMapping("/{orderId}/delete")
    public String deleteOrder(@PathVariable("orderId")Long orderId) {
        orderService.deleteOrder(orderId);
        return "redirect:/orders";
    }
    @GetMapping("/{orderId}/view")
    public String viewOrder(@PathVariable("orderId")Long orderId, Model model) {

        Order orderToView = orderService.getOrderById(orderId);
        model.addAttribute("order", orderToView);

        return "orders/view-order";
    }
}
