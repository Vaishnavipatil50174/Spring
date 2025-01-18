package com.epam.user_management_tool.service;

import com.epam.user_management_tool.dto.UserRequest;
import com.epam.user_management_tool.entity.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {
    User updateById(UserRequest user) throws Throwable;

    void deleteById(int id) throws Throwable;

    Page<User> getAll(Integer pageNumber, Integer pageSize);
    List<User> getAllUser();

    User getUserById(Integer userId) throws Throwable;

    User createUser(UserRequest userRequest);


}
