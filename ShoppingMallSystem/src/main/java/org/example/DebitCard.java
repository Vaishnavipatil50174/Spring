package org.example;

import org.springframework.stereotype.Component;

@Component
public class DebitCard implements Card {
    @Override
    public void method() {
        System.out.println("Its Debit Card");
    }
}
