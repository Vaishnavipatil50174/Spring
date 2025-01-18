package com.epam.user_management_tool.service;

import com.epam.user_management_tool.dto.UserRequest;
import com.epam.user_management_tool.entity.User;
import com.epam.user_management_tool.exception.UserException;
import com.epam.user_management_tool.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    private final ObjectMapper objectMapper;

    public UserServiceImp(UserRepository userRepository, ObjectMapper objectMapper) {
        this.userRepository = userRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public User updateById(UserRequest userRequest) throws Throwable {
        User user= objectMapper.convertValue(userRequest,User.class);
        userRepository.findById(user.getId()).orElseThrow(()->
                new UserException("User not found for the Id:" + user.getId()+" please create new user",HttpStatus.NOT_FOUND)
        );
        return this.userRepository.save(user);
    }
    @Override
    public void deleteById(int id) throws Throwable{
        userRepository.findById(id).orElseThrow(()->
                new UserException("User not found for the Id:" + id,HttpStatus.NOT_FOUND)
        );
        userRepository.deleteById(id);
    }

    @Override
    public Page<User> getAll(Integer pageNumber, Integer pageSize) {
       return userRepository.findAll(PageRequest.of(pageNumber, pageSize));
    }

    @Override
    public User getUserById(Integer userId) throws Throwable {
        return userRepository.findById(userId).orElseThrow(()-> new UserException("user not found for id:"+userId,HttpStatus.NOT_FOUND)
        );
    }

    @Override
    public User createUser(UserRequest userRequest) {
        User newUser = this.objectMapper.convertValue(userRequest, User.class);
        try {
            this.userRepository.save(newUser);
        } catch (Exception ex) {

            log.error("Error occurred while creating an user");

            throw new UserException("User can not be created with duplicate email", HttpStatus.CONFLICT);
        }
        return newUser;
    }
    public List<User> getAllUser(){
        return userRepository.findAll();
    }




}
