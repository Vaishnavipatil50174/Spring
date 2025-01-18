package com.epam.user.management.project.usermanagement.repository;

import com.epam.user.management.project.usermanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

//    @Query("SELECT u FROM User u WHERE u.name = :name")
//    User findByName(@Param("name") String name);

    @Query(value = "SELECT * FROM users WHERE name= :name",nativeQuery = true)
    User findByName12(@Param("name") String name);



    @Query("SELECT u.name FROM User u ORDER BY u.name ASC")
    List<String> findAllUserNamesOrderedByName();





   
}
