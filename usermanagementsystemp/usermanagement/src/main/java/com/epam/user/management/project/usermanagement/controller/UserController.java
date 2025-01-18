package com.epam.user.management.project.usermanagement.controller;

import com.epam.user.management.project.usermanagement.dto.UserRequest;
import com.epam.user.management.project.usermanagement.model.Address;
import com.epam.user.management.project.usermanagement.model.Role;
import com.epam.user.management.project.usermanagement.model.User;
import com.epam.user.management.project.usermanagement.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    public void addAll(@Valid @RequestBody UserRequest userRequest){
        User user=this.objectMapper.convertValue(userRequest, User.class);
        userService.add(user);
    }

    @GetMapping("pageNumber/{pageNumber}/pageSize/{pageSize}")
    public Page<User> getAllUser(@PathVariable("pageNumber") Integer pageNumber,
                                 @PathVariable("pageSize") Integer pageSize){
        return userService.getAll(pageNumber, pageSize);
    }

    @GetMapping("{id}")
    public User byIdi(@PathVariable Integer id){
        return userService.byId(id);
    }

    @PutMapping("/update")
    public User updateAll(@RequestBody User user){

        return userService.update(user);
    }

    @DeleteMapping("{id}")
    public void del(@PathVariable Integer id){
        userService.deleteRecord(id);
    }

//List of user using rolename
    @GetMapping("/role/{roleName}")
    public List<User> getUsersByRole(@PathVariable String roleName) {
        return userService.byRole(roleName);
    }
//list of name using rolename
    @GetMapping("/role/name/{roleName}")
    public List<String> getNamesByRole(@PathVariable String roleName) {
        return userService.nameByRole(roleName);
    }

//remove Role Name By Id
    @PutMapping("role/{id}/{roleName}")
    public void removeByIdroleName(@PathVariable Integer id,@PathVariable String roleName){
        userService.removeRoleById(id,roleName);
    }

//Add Role By ID

    @PutMapping("role/adrole/{id}")
    public void addRoleByIdi(@PathVariable Integer id, @RequestBody Role role){
        userService.addRoleById(id,role);
    }
//List Of Address by id

    @GetMapping("address/{id}")
    public List<Address> addressById(@PathVariable Integer id){
        return userService.addressById(id);
    }
//Showing Roles Using Id
    @GetMapping("roles/{id}")
    public List<Role> roleById(@PathVariable Integer id){
        return userService.rolesById(id);
    }

//    Adding Addresses using id

    @PutMapping("address/add/{id}")
    public void addAddress(@PathVariable Integer id,@RequestBody Address address){
        userService.addAddress(id,address);
    }

    @DeleteMapping("address/del/{id}/{addName}")
    public User RemoveAddress(@PathVariable Integer id,@PathVariable String addName){
        return userService.removeAddressById(id,addName);
    }

    @GetMapping("/new/name/{name}")
    public User byName1(@PathVariable String name){
        return userService.byName(name);
    }
    @GetMapping("/name/asc")
    public List<String> ascName(){
        return userService.allNameAsc();
    }
}
