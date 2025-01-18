package com.epam.notificationsystemusingspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountServiceController {
    @Autowired
    AccountService accountService;
    @RequestMapping("/")
    public String show(){
        return accountService.display();

    }
    @RequestMapping("/sms")
    public String aboutSms(){
        return accountService.onlySms();
    }




}
