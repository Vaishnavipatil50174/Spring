package com.epam.notificationsystemusingspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component

public class AccountService {
    @Autowired
    NotificationAPI smsNotification;
    @Autowired
    NotificationAPI emailNotification;

    public String display(){
        return smsNotification.notifination()+emailNotification.notifination();
    }
    public String onlySms(){
        return smsNotification.notifination();
    }
}
