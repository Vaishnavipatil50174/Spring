package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class AccountService {
    //@Autowired
    NotificationAPI sms;
    //@Autowired
    NotificationAPI insta;
//    @Autowired
    public AccountService(@Qualifier("sms") NotificationAPI sms,@Qualifier("insta") NotificationAPI insta) {
        this.sms = sms;
        this.insta = insta;
    }

    public String transaction(){
        return  sms.notification()+ ":"+ insta.notification();
        //return "SMS:Instagram";

    }
}
