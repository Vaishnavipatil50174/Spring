package com.epam.user_management_tool.repository;

import com.epam.user_management_tool.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
