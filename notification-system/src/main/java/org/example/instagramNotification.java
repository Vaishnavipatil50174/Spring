package org.example;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component

public class instagramNotification implements NotificationAPI{
    @Override
    public void notification() {
        System.out.println("instgram");
    }
}
