package org.example;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class CreditCard implements Card, InitializingBean, DisposableBean {
    @Override
    public void method() {
        System.out.println("Its Credit card");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Destroy method is working");
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        System.out.println("Initializaton of bean is there");

    }
}
