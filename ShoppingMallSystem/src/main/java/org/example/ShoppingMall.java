package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class ShoppingMall {
    public static void main(String[] args) {

        ApplicationContext context=new AnnotationConfigApplicationContext(ShoppingMall.class);

        BankCard bankCard=context.getBean(BankCard.class);
        bankCard.display();

        ((AnnotationConfigApplicationContext)context).registerShutdownHook();



    }
}
