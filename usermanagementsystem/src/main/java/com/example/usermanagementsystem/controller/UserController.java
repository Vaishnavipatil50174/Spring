package com.example.usermanagementsystem.controller;

import com.example.usermanagementsystem.model.User;
import com.example.usermanagementsystem.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Component
@RequiredArgsConstructor
public class UserController {
    @Autowired
    public UserService userService;

    //private final ObjectMapper objectMapper;

    @PostMapping("user")
    public void add(@RequestBody User user){
        //User user1 = this.objectMapper.convertValue(user, User.class);
        userService.addUser(user);
    }

    @GetMapping("/user")
    public List<User>show(){
        return userService.getUserRepo();
    }


}
