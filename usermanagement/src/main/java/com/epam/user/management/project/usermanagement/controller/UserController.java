package com.epam.user.management.project.usermanagement.controller;

import com.epam.user.management.project.usermanagement.dto.UserRequest;
import com.epam.user.management.project.usermanagement.model.Address;
import com.epam.user.management.project.usermanagement.model.Role;
import com.epam.user.management.project.usermanagement.model.User;
import com.epam.user.management.project.usermanagement.service.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;
    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping
    public void addUser(@Valid @RequestBody UserRequest userRequest){
        User user=objectMapper.convertValue(userRequest,User.class);

        userServiceImpl.addUser(user);
    }

    @GetMapping
    public List<User> showAllUser(){
        return userServiceImpl.showAllUser();
    }

    @GetMapping("{id}")
    public User getUserById(@PathVariable Integer id){
        return userServiceImpl.getById(id);
    }

    @PutMapping("/updateuser")
    public User updateUser(@RequestBody User user){
        return userServiceImpl.updateUser(user);
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable Integer id){
        userServiceImpl.deleteRecord(id);
    }

//List of user using rolename
    @GetMapping("/role/{roleName}")
    public List<User> getUsersByRole(@PathVariable String roleName) {
        return userServiceImpl.byRole(roleName);
    }
//list of name using rolename
    @GetMapping("/role/name/{roleName}")
    public List<String> getNamesByRole(@PathVariable String roleName) {
        return userServiceImpl.nameByRole(roleName);
    }

//remove Role Name By Id
    @PutMapping("role/{id}/{roleName}")
    public void removeByIdroleName(@PathVariable Integer id,@PathVariable String roleName){
        userServiceImpl.removeRoleById(id,roleName);
    }

//Add Role By ID

    @PutMapping("role/adrole/{id}")
    public void addRoleByIdi(@PathVariable Integer id, @RequestBody Role role){
        userServiceImpl.addRoleById(id,role);
    }
//List Of Address by id

    @GetMapping("address/{id}")
    public List<Address> addressById(@PathVariable Integer id){
        return userServiceImpl.addressById(id);
    }
//Showing Roles Using Id
    @GetMapping("roles/{id}")
    public List<Role> roleById(@PathVariable Integer id){
        return userServiceImpl.rolesById(id);
    }

//    Adding Addresses using id

    @PutMapping("address/add/{id}")
    public void addAddress(@PathVariable Integer id,@RequestBody Address address){
        userServiceImpl.addAddress(id,address);
    }

    @DeleteMapping("address/del/{id}/{addName}")
    public User RemoveAddress(@PathVariable Integer id,@PathVariable String addName){
        return userServiceImpl.removeAddressById(id,addName);
    }
}
