package org.example;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component

public class Sms implements NotificationAPI{
    @Override
    public String notification() {
        return "SMS";
    }
}
