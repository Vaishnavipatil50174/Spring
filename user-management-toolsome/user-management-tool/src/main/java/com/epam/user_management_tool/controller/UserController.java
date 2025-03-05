package com.epam.user_management_tool.controller;

import com.epam.user_management_tool.dto.UserRequest;
import com.epam.user_management_tool.entity.User;
import com.epam.user_management_tool.exception.UserException;
import com.epam.user_management_tool.service.UserServiceImp;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Slf4j
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserServiceImp userService;

    @PostMapping
    public ResponseEntity<User> createUser(@Validated @RequestBody UserRequest userRequest) {
            User user = userService.createUser(userRequest);
            return new ResponseEntity<>(user,HttpStatus.CREATED);

    }


    @GetMapping("/all")
    public List<User> all(){
        return userService.getAllUser();
    }
    @GetMapping("pageNumber/{pageNumber}/pageSize/{pageSize}")
    public Page<User> getAllUser(@PathVariable("pageNumber") Integer pageNumber,
                                 @PathVariable("pageSize") Integer pageSize){
        return userService.getAll(pageNumber, pageSize);
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Integer userId) throws  Throwable {
        return userService.getUserById(userId);
    }

    @PutMapping
    public User updateUserById(@Valid @RequestBody UserRequest userRequest) throws Throwable {
        return userService.updateById(userRequest);
    }


    @DeleteMapping({"/{userId}"})
    public void deleteUserById( @PathVariable("userId") Integer userId) throws Throwable {
        userService.deleteById(userId);
    }






}
