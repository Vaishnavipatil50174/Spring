package com.epam.techcheckfourth.controller;

import com.epam.techcheckfourth.model.User;
import com.epam.techcheckfourth.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping
    public void save1(@Valid @RequestBody User user){
        userService.save(user);
    }

    @GetMapping
    public List<User> showAll(){
        return userService.getAll();
    }
    @GetMapping("/{id}")
    public User btid(@PathVariable Integer id){
        return userService.findbyid(id);
    }

}
