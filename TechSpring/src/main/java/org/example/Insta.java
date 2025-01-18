package org.example;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component

public class Insta implements NotificationAPI{
    @Override
    public String notification() {
        return "Instgram";
    }
}
