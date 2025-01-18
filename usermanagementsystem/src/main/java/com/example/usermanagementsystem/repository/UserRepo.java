package com.example.usermanagementsystem.repository;

import com.example.usermanagementsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
