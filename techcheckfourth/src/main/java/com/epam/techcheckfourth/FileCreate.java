package com.epam.techcheckfourth;

import com.epam.techcheckfourth.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class FileCreate {
    public static void main(String[] args) throws IOException {
        User user=new User(1,"sonu");

        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.writeValue(new File("data.json"),user);
        System.out.println("done");
    }
}
