package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

public class AccountServicetest3 {

    @Mock
    NotificationAPI sms;

    @Mock
    NotificationAPI insta;

    @InjectMocks
    AccountService accountService;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
//        doNothing().when(sms).notification();
//        doNothing().when(insta).notification();

        when(sms.notification()).thenReturn("SMS");
        when(insta.notification()).thenReturn("Instgram");
    }

    @Test
    public void testtran(){

        assertEquals("SMS:Instgram",accountService.transaction());
    }
}
