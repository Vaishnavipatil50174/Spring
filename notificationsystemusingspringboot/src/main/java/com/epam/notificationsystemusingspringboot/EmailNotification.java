package com.epam.notificationsystemusingspringboot;

import org.springframework.stereotype.Component;

@Component
public class EmailNotification implements NotificationAPI{
    @Override
    public String notifination() {
        return  "Email Notification ";
    }
}
