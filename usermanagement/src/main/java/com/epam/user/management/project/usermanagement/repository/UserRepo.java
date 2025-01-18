package com.epam.user.management.project.usermanagement.repository;

import com.epam.user.management.project.usermanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

public interface UserRepo extends JpaRepository<User,Integer> {
   
}
