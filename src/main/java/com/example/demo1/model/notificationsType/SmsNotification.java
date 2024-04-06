package com.example.demo1.model.notificationsType;

import com.example.demo1.model.Notification;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@ToString(callSuper = true)
public class SmsNotification extends Notification {

    private String recipientNumber;
    private String senderNumber;

}
