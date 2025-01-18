package com.epam.user.management.project.usermanagement.controller;

import com.epam.user.management.project.usermanagement.dto.UserRequest;
import com.epam.user.management.project.usermanagement.model.Address;
import com.epam.user.management.project.usermanagement.model.Role;
import com.epam.user.management.project.usermanagement.model.User;
import com.epam.user.management.project.usermanagement.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping
    public void add(@Valid @RequestBody UserRequest userRequest){
        User user=this.objectMapper.convertValue(userRequest, User.class);
        userService.add(user);
    }

    @GetMapping
    public List<User> showAll(){
        return userService.show();
    }

    @GetMapping("{id}")
    public User getById(@PathVariable Integer id){
        return userService.byId(id);
    }

    @PutMapping("{id}")
    public User updateAll(@RequestBody User user){
        return userService.update(user);
    }

    @DeleteMapping("{id}")
    public void del(@PathVariable Integer id){
        userService.deleteRecord(id);
    }


}
