package com.example.usermanagementsystem.service;

import com.example.usermanagementsystem.model.User;
import com.example.usermanagementsystem.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    public UserRepo userRepo;

    public void addUser(User user){
        userRepo.save(user);
    }

    public List<User> getUserRepo() {
        return userRepo.findAll();
    }
}
