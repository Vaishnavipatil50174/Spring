package com.epam.notificationsystemusingspringboot;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class AccountServiceTest {

    @Mock
    NotificationAPI smsNotification;

    @Mock
    NotificationAPI emailNotification;

    @InjectMocks
    AccountService accountService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);

    }

    @Test
    public void serT(){
        when(smsNotification.notifination()).thenReturn("SMS");
        when(emailNotification.notifination()).thenReturn("Instagram");

        assertEquals("SMS",accountService.onlySms());
    }
}
