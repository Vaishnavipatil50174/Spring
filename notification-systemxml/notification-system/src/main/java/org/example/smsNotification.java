package org.example;

import org.springframework.stereotype.Component;


public class smsNotification implements NotificationAPI{
    @Override
    public void notification() {
        System.out.println("sms");
    }
}
