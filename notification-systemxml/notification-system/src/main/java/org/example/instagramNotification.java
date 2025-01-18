package org.example;

import org.springframework.stereotype.Component;


public class instagramNotification implements NotificationAPI{
    @Override
    public void notification() {
        System.out.println("instgram");
    }
}
