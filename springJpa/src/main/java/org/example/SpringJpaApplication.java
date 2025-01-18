package org.example;

import org.example.Service.UserService;
import org.example.entity.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringJpaApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JpaConfig.class);

        // Make sure the UserService bean can be retrieved
        UserService userService = context.getBean(UserService.class);
        if (userService == null) {
            System.out.println("UserService bean not found!");
            return;
        }

        // Example usage: Create a new user
        User newUser = new User();
        newUser.setFirstName("John");
        newUser.setLastName("Doe");
        newUser.setEmail("john.doe@example.com");

        // Save the user to the database
        userService.saveUser(newUser);

        // Retrieve and print user by ID
        User retrievedUser = userService.getUserById(newUser.getId());
        if (retrievedUser != null) {
            System.out.println("Retrieved User: " + retrievedUser.getFirstName() + " "
                    + retrievedUser.getLastName() + ", " + retrievedUser.getEmail());
        } else {
            System.out.println("User not found!");
        }

        // Close the application context
        context.close();
    }

}
