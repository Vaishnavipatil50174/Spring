package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BankCard {
    @Autowired
    private Card creditCard;

    void display(){
        creditCard.method();
    }
}
