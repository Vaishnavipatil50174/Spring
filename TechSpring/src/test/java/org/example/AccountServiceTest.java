package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

//@ExtendWith(MockitoAnnotations.class)
public class AccountServiceTest {
    @Mock
    private NotificationAPI sms;

    @Mock
    private NotificationAPI insta;

    @InjectMocks
    private AccountService accountService;
    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void tran(){
//        doAnswer(invocation -> {
//            System.out.println("SMS");
//            return null; // Returning null since notification() is void
//        }).when(sms).notification();
//
//        doAnswer(invocation -> {
//            System.out.println("Instagram");
//            return null; // Returning null since notification() is void
//        }).when(insta).notification();

        when(sms.notification()).thenReturn("SMS");
        when(insta.notification()).thenReturn("Instagram");

        String result=accountService.transaction();
        assertEquals("SMS:Instagram",result);



    }







}
