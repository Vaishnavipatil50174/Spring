package org.example;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
//@Scope("prototype")
public class AccountService {
//    @Autowired
    //@Qualifier(value = "instagramNotification")
    @Resource(name = "instagramNotification")
    private NotificationAPI smsNotification;
    @Autowired
    private NotificationAPI instagramNotification;
//      @Autowired
//      public void accountTransaction(){
//         this.smsNotification.notification();
//         //this.instgramNotification.notification();
//    }

    //giving mwe error

    public void accountTransaction(){
        smsNotification.notification();
        instagramNotification.notification();

    }


//    @Autowired
//    public void setSmsNotification(NotificationAPI smsNotification) {
//        this.smsNotification = smsNotification;
//    }

    // Setter for instagramNotification
//    @Autowired
//    public void setInstagramNotification(NotificationAPI instagramNotification) {
//        this.instagramNotification = instagramNotification;
//    }

//    public void accountTransaction() {
//        smsNotification.notification();
//        //instagramNotification.notification();
//    }

//    public NotificationAPI getSmsNotification() {
//        return smsNotification;
//    }
//
//    public void setSmsNotification(NotificationAPI smsNotification) {
//        this.smsNotification = smsNotification;
//    }
//
//    public NotificationAPI getInstgramNotification() {
//        return instgramNotification;
//    }
//
//    public void setInstgramNotification(NotificationAPI instgramNotification) {
//        this.instgramNotification = instgramNotification;
//    }
}
