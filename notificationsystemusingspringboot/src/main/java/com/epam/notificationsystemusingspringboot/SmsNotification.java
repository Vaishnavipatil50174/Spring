package com.epam.notificationsystemusingspringboot;

import org.springframework.stereotype.Component;

@Component
public class SmsNotification implements NotificationAPI{
    @Override
    public String notifination() {
        return "SMS Notification";
    }
}
