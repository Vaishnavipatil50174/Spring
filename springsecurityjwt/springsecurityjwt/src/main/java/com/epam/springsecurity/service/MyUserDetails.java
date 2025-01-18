package com.epam.springsecurity.service;

import com.epam.springsecurity.model.UserPrinciple;
import com.epam.springsecurity.model.Users;
import com.epam.springsecurity.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetails implements UserDetailsService {

    @Autowired
    UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepo.findByUsername(username);
        if (user == null) {
            System.out.println("User Not Found for username: " + username);
            throw new UsernameNotFoundException("Not Found");
        }
        System.out.println("User found: " + user.getUsername());
        return new UserPrinciple(user);
    }
}
