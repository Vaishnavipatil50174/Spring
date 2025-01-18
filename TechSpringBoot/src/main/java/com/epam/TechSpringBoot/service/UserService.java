package com.epam.TechSpringBoot.service;

import com.epam.TechSpringBoot.model.Address;
//import com.epam.TechSpringBoot.model.Course;
import com.epam.TechSpringBoot.model.Course;
import com.epam.TechSpringBoot.model.User;
import com.epam.TechSpringBoot.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public void add(User user){
        for (Address address : user.getAddresses()) {
            System.out.println("Address aName: " + address.getA_Name()); // Debugging line
            address.setUser(user);  // Set the User reference for each Address
        }
        userRepo.save(user);

        for (Course course : user.getCourses()) {
            // Add the user to each course (if you are maintaining the reference)
            //course.getUser().add(user); // Assuming courses have a reference to users

            //course.setUser(user);
            System.out.println(course.getC_Name());
        }
//        for (Course course : user.getCourses()) {
//            // Add the user to the course's user list if it doesn't exist yet
//            if (!course.getUser().contains(user)) {
//                course.getUser().add(user);
//            }
//        }




    }

    public List<User> show(){
        return  userRepo.findAll();
    }
}
