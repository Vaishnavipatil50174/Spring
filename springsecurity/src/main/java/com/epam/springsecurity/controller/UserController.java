package com.epam.springsecurity.controller;

import com.epam.springsecurity.model.Users;
import com.epam.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
     @Autowired
     private UserService userService;
    @PostMapping("/register")
    public Users register(@RequestBody Users user){
        return userService.register(user);

    }
}
