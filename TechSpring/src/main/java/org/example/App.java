package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(App.class);

        AccountService accountService=applicationContext.getBean(AccountService.class);

        System.out.println(accountService.transaction());
//        System.out.println(accountService.hashCode());
//
//        AccountService accountService1=applicationContext.getBean(AccountService.class);
//        System.out.println(accountService1.hashCode());


//        System.out.println( "Hello World!" );
    }
}
