package com.epam.TechSpringBoot.repository;

import com.epam.TechSpringBoot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
}
