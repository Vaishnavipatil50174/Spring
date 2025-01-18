package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class MainClasss {
    public static void main(String[] args) {
//        NotificationAPI smsNotification = new smsNotification();
//        NotificationAPI instagramNotification = new instagramNotification();
//        AccountService accountService=new AccountService();
//        accountService.setSmsNotification(smsNotification);
//        accountService.setInstgramNotification(instagramNotification);
//        accountService.accountTransaction();

        ApplicationContext context = new AnnotationConfigApplicationContext(MainClasss.class);

        // Retrieve the AccountService bean from the context
        AccountService accountService = context.getBean(AccountService.class);

        // Call the method
        accountService.accountTransaction();
        System.out.println(accountService.hashCode());

        AccountService accountService1 = context.getBean(AccountService.class);

        System.out.println(accountService1.hashCode());
    }
}
