package com.epam.techcheckfourth.repository;

import com.epam.techcheckfourth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer>{
}
