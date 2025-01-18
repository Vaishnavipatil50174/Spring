package com.epam.springsecurity.controller;

import com.epam.springsecurity.model.Users;
import com.epam.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

    @PostMapping("/login1")
    public ResponseEntity<?> login(@RequestBody Users user) {
        String token = userService.verify(user);
        if ("fail".equals(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed");
        }
        return ResponseEntity.ok("Bearer " + token);
    }
}
