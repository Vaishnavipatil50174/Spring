package com.epam.techcheckfourth.service;

import com.epam.techcheckfourth.exception.UserNotValid;
import com.epam.techcheckfourth.model.User;
import com.epam.techcheckfourth.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;
    public void save(User user){
        userRepo.save(user);
    }
    public List<User> getAll(){
        return userRepo.findAll();
    }
    public User findbyid(Integer id){
        User user=userRepo.findById(id).orElseThrow(()->new UserNotValid("Not Id Found"));

        return user;

    }
}
