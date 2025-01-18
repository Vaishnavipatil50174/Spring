package com.epam.springsecurity.service;

import com.epam.springsecurity.model.Users;
import com.epam.springsecurity.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public Users register(Users user){
        return userRepo.save(user);
    }
}
