package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


//@Scope("prototype")
public class AccountService {

    private NotificationAPI smsNotification;
    private NotificationAPI instagramNotification;
    public AccountService(NotificationAPI smsNotification,NotificationAPI instagramNotification){
        this.smsNotification=smsNotification;
        this.instagramNotification=instagramNotification;
    }

    public void accountTransaction(){
        smsNotification.notification();
        instagramNotification.notification();

    }


}
