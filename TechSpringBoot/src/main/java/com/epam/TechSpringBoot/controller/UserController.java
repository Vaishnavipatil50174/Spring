package com.epam.TechSpringBoot.controller;

import com.epam.TechSpringBoot.model.User;
import com.epam.TechSpringBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/greet")
    public Integer greet(){
        return 124;
    }

    @GetMapping("/user")
    public List<User> show1(){
        return userService.show();
    }

    @PostMapping("/user")
    public void add1(@RequestBody User user){
        userService.add(user);

    }
}
