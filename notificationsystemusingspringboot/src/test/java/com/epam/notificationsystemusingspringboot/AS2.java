package com.epam.notificationsystemusingspringboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest

public class AS2 {
    @Autowired
    AccountService accountService;

    @Test
    public void testA(){
        assertEquals("SMS NotificationEmail Notification",accountService.display().trim());
    }
}
