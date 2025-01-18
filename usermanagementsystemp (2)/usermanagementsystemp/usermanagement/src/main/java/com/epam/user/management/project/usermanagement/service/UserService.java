package com.epam.user.management.project.usermanagement.service;

import com.epam.user.management.project.usermanagement.exception.InvalidUserException;
import com.epam.user.management.project.usermanagement.exception.UserException;
import com.epam.user.management.project.usermanagement.model.Address;
import com.epam.user.management.project.usermanagement.model.Role;
import com.epam.user.management.project.usermanagement.model.User;
import com.epam.user.management.project.usermanagement.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public void add(User user){
        userRepo.save(user);
    }

    public List<User> show(){
        return userRepo.findAll();
    }

    public User byId(Integer id){
        return userRepo.findById(id).orElseThrow(()-> new UserException("No Record at the"+ id));
    }
    public User update(User user){

        return userRepo.save(user);
    }
    public void deleteRecord(Integer id){
        User user1=userRepo.findById(id).orElseThrow(()-> new UserException("No Such Record in the database"));
        userRepo.delete(user1);
    }



}
