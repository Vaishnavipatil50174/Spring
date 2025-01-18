package com.epam.user.management.project.usermanagement.service;

import com.epam.user.management.project.usermanagement.exception.InvalidUserException;
import com.epam.user.management.project.usermanagement.exception.UserException;
import com.epam.user.management.project.usermanagement.model.Address;
import com.epam.user.management.project.usermanagement.model.Role;
import com.epam.user.management.project.usermanagement.model.User;
import com.epam.user.management.project.usermanagement.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    public Page<User> getAll(Integer pageNumber, Integer pageSize) {
        return userRepo.findAll(PageRequest.of(pageNumber, pageSize));
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

    public List<User>byRole(String roleName){
        List<User>allUsers=userRepo.findAll();

//        return allUsers.stream()
//                .filter(user-> user.getRoles().stream().anyMatch(role->role.getRole().equalsIgnoreCase(roleName)))
//                .collect(Collectors.toList());



        return allUsers.stream()
                .flatMap(user -> user.getRoles().stream()
                        .filter(role -> role.getRole().equalsIgnoreCase(roleName))
                        .map(role -> user)) // Map back to user
                        .collect(Collectors.toList());
    }

    public List<String> nameByRole(String roleName){
        List<User>allUsers=userRepo.findAll();

        return allUsers.stream()
                .flatMap(user -> user.getRoles().stream()
                        .filter(role -> role.getRole().equalsIgnoreCase(roleName))
                        .map(role -> user.getName())) // Map back to user
                .collect(Collectors.toList());
    }

    public void removeRoleById(Integer id,String roleName){
        User user=userRepo.findById(id).get();
        user.getRoles().removeIf(role -> role.getRole().equals(roleName));
        userRepo.save(user);
    }

    public void addRoleById(Integer id, Role role){
        User user=userRepo.findById(id).get();
        user.getRoles().add(role);

        userRepo.save(user);

    }

    public List<Address> addressById(Integer id){
        User user=userRepo.findById(id).orElseThrow(()-> new InvalidUserException("User is not"));
        List<Address>addressList= user.getAddresses().stream()
                .collect(Collectors.toList());
        return  addressList;
    }


    public List<Role> rolesById(Integer id){
        User user=userRepo.findById(id).orElseThrow(()-> new InvalidUserException("User is not"));
        List<Role>roleList= user.getRoles().stream()
                .collect(Collectors.toList());
        return  roleList;
    }

    public void addAddress(Integer id,Address address){
        User user=userRepo.findById(id).orElseThrow(()-> new InvalidUserException("User Not Found"));

        user.getAddresses().add(address);
        userRepo.save(user);
    }


    public User removeAddressById(Integer id,String addressName){
        User user=userRepo.findById(id).orElseThrow(()-> new InvalidUserException("Not Found"));
        user.getAddresses().removeIf(address->address.getAddressname().equalsIgnoreCase(addressName));
        return userRepo.save(user);

    }

    public User byName(String name){
        return userRepo.findByName12(name);
    }

    public List<String> allNameAsc(){
        return userRepo.findAllUserNamesOrderedByName();
    }


}
