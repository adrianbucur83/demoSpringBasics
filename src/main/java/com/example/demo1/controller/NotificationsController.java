package com.example.demo1.controller;


import com.example.demo1.model.Notification;
import com.example.demo1.model.notificationsType.SmsNotification;
import com.example.demo1.service.impl.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//
@Controller
@RequestMapping("/notifications")
public class NotificationsController {


    private final NotificationService notificationService;

    @Autowired
    public NotificationsController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping()
    public String getAllNotifications(Model model){
        model.addAttribute("notifications", notificationService.getAllNotifications());
        return "notificationsView/notifications";

    }

    @GetMapping("/{id}")
    public String getNotificationById(@PathVariable("id") int id,Model model){
        model.addAttribute("notifications", notificationService.getNotificationById(id));
        return "notificationsView/notifications";
    }


    @PostMapping("/add")
    @ResponseBody
    public String addNotification(){
        SmsNotification notification = notificationService.addNotification();

        return notification.toString() + "- notification added";
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    public String updateById(@PathVariable("id") int id){

        //notificationService.updateById();

        return "Notification with id "+ id +" has been updated";
    }


    @DeleteMapping("/delete")
    @ResponseBody
    public String deleteAll(){
        //notificationService.deleteAll();
        return "Notifications have been deleted";
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public String deleteById(@PathVariable("id") int id){
        //notificationService.deleteById();
        return "Notification with id " + id + " have been deleted";
    }



}
