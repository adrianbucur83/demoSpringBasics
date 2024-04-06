package com.example.demo1.service.impl;

import com.example.demo1.model.Notification;
import com.example.demo1.model.notificationsType.EmailNotification;
import com.example.demo1.model.notificationsType.SmsNotification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class NotificationService {


    List<Notification> notificationList = new ArrayList<>();

    public List<Notification> getAllNotifications() {

        List<Notification> notificationsList = new ArrayList<>();

        EmailNotification emailNotification1 = EmailNotification.builder()
                .id(1)
                .message("Email marketing message1")
                .recipientEmail("testmail1@gmail.com")
                .senderEmail("myemail1@gmail.com")
                .timestamp(new Date())
                .build();

        EmailNotification emailNotification2 = EmailNotification.builder()
                .id(2)
                .message("Email marketing message2")
                .recipientEmail("testmail2@gmail.com")
                .senderEmail("myemail2@gmail.com")
                .timestamp(new Date())
                .build();

        SmsNotification smsNotification1 = SmsNotification.builder()
                .id(3)
                .message("SMS marketing message1")
                .recipientNumber("07phoneNumber")
                .senderNumber("07myPhoneNumber")
                .timestamp(new Date())
                .build();

        notificationsList.add(emailNotification1);
        notificationsList.add(emailNotification2);
        notificationsList.add(smsNotification1);
        return notificationsList;

    }

    public List<Notification> getNotificationById(int id){
        //TODO: Get the notification from the database by the id

        //functie facuta doar sa afisez ceva
        List<Notification> notificationsList = new ArrayList<>();

        notificationsList.add( SmsNotification.builder()
                .id(id)
                .message("SMS marketing message1")
                .recipientNumber("07phoneNumber")
                .senderNumber("07myPhoneNumber")
                .timestamp(new Date())
                .build());

        return notificationsList;
    }

    public SmsNotification addNotification() {

        //TODO: Add notification to the database

        return SmsNotification.builder()
                .id(4)
                .message("SMS marketing message2")
                .recipientNumber("07123phoneNumber")
                .senderNumber("07123myPhoneNumber")
                .timestamp(new Date())
                .build();
    }
}
