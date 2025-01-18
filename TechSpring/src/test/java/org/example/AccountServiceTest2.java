package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;

import static junit.framework.Assert.assertEquals;
//@ExtendWith(SpringExtension.class)
//@SpringBootTest

public class AccountServiceTest2 {


    NotificationAPI sms=new Sms();
    NotificationAPI insta=new Insta();
    AccountService accountService=new AccountService(sms,insta);
//    @BeforeEach
//    void setup(){
//        sms=new Sms();
//        insta=new Insta();
//        accountService=new AccountService(sms,insta);
//    }



    @Test
    public void testAcc(){


        assertEquals("SMS:Instgram",accountService.transaction());
    }
}


