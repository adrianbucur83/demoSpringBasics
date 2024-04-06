package com.example.demo1.model.notificationsType;

import com.example.demo1.model.Notification;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@ToString(callSuper = true)
public class EmailNotification extends Notification {

    private String recipientEmail;
    private String senderEmail;
    private String subject;

}
