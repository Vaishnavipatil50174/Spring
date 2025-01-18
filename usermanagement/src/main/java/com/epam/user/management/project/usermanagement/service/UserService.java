package com.epam.user.management.project.usermanagement.service;

import com.epam.user.management.project.usermanagement.model.Address;
import com.epam.user.management.project.usermanagement.model.Role;
import com.epam.user.management.project.usermanagement.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    List<User> showAllUser();

    User getById(Integer id);

    User updateUser(User user);

    void deleteRecord(Integer id);

    List<User> byRole(String roleName);

    List<String> nameByRole(String roleName);

    void removeRoleById(Integer id, String roleName);

    void addRoleById(Integer id, Role role);

    List<Address> addressById(Integer id);

    List<Role> rolesById(Integer id);

    void addAddress(Integer id, Address address);

    User removeAddressById(Integer id, String addressName);
}
