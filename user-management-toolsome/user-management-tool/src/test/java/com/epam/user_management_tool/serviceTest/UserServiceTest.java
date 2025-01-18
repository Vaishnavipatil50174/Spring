package com.epam.user_management_tool.serviceTest;

import com.epam.user_management_tool.dto.UserRequest;
import com.epam.user_management_tool.entity.Address;
import com.epam.user_management_tool.entity.Role;
import com.epam.user_management_tool.entity.User;
import com.epam.user_management_tool.exception.UserException;
import com.epam.user_management_tool.repository.UserRepository;
import com.epam.user_management_tool.service.UserServiceImp;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
public class UserServiceTest {


    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserServiceImp userServiceImp;

    @Mock
    ObjectMapper objectMapper;
    // Test for GetById Method
    @Test
    public void testsForGetById() throws Throwable{
        User user=new User();
        user.setId(1);
        user.setName("vaish");
        user.setEmail("vaish@epam.com");
        user.setGender("Female");
        user.setAddresses(new ArrayList<>(Arrays.asList(new Address(1, "Satara","Work","Satara"))));
        user.setRoles(new ArrayList<>(Arrays.asList(new Role(1, "Admin"))));

        when(userRepository.findById(1)).thenReturn(Optional.of(user));

        Assertions.assertEquals("vaish", userServiceImp.getUserById(1).getName());
    }


    @Test
    public void test_getUserByIdNotFound(){
        Mockito.when(userRepository.findById(1)).thenReturn(Optional.empty());

        Assertions.assertThrows(UserException.class,()-> userServiceImp.getUserById(1),"User is not found for the ID:");
    }

    // Test for updateById method
    @Test
    public void test_updateById_Success() throws Throwable {

        // Create an existing user object from the database
        User existingUser = new User();
        existingUser.setId(1);
        existingUser.setName("vaish");
        existingUser.setEmail("vaish@epam.com");
        existingUser.setGender("Female");
        existingUser.setAddresses(new ArrayList<>(Arrays.asList(new Address(1, "Satara", "Work", "Satara"))));
        existingUser.setRoles(new ArrayList<>(Arrays.asList(new Role(1, "Admin"))));

        // Create a UserRequest object simulating the incoming update request
        UserRequest userRequest = new UserRequest();
        userRequest.setId(1);  // Ensure the same ID is set
        userRequest.setName("vaish_updated"); // Updated name
        userRequest.setEmail("vaish_updated@epam.com"); // Updated email

        //(this is the expected result)
        User updatedUser = new User();
        updatedUser.setId(1);
        updatedUser.setName("vaish_updated");
        updatedUser.setEmail("vaish_updated@epam.com");
        updatedUser.setGender("Female");
        updatedUser.setAddresses(new ArrayList<>(Arrays.asList(new Address(1, "Satara", "Work", "Satara"))));
        updatedUser.setRoles(new ArrayList<>(Arrays.asList(new Role(1, "Admin"))));

        // Mock the ObjectMapper behavior to map the request to an existing user
        when(objectMapper.convertValue(userRequest, User.class)).thenReturn(updatedUser);

        // Mock the repository behavior for finding the user by ID and saving the updated user
        when(userRepository.findById(1)).thenReturn(Optional.of(existingUser)); // Simulate existing user in DB
        when(userRepository.save(updatedUser)).thenReturn(updatedUser); // Simulate saving the updated user

        // Act
        User result = userServiceImp.updateById(userRequest); // Call the update method

        // Assert
        //Assertions.assertNotNull(result); // Ensure the result is not null
        Assertions.assertEquals("vaish_updated", result.getName()); // Check if the name was updated
        Assertions.assertEquals("vaish_updated@epam.com", result.getEmail()); // Check if the email was updated
        Assertions.assertEquals("Female", result.getGender()); // Gender remains the same
        Assertions.assertEquals(1, result.getAddresses().size()); // Address should still be present
//        Assertions.assertEquals("Satara", result.getAddresses().get(0).getAddressCity()); // Address fields remain the same
    }


    //For deletebyid method
    @Test
    public void test_deleteById_Success() throws Throwable {
        int userId = 1;

        // Mock the existence of the user in the repository
        User user = new User();
        user.setId(userId);
        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        // Call the deleteById method
        userServiceImp.deleteById(userId);

        // Verify that deleteById was called on the repository
        Mockito.verify(userRepository, Mockito.times(1)).deleteById(userId);
    }


    @Test
    public void test_deleteById_UserNotFound() throws Throwable {
        int userId = 1;

        // Mock the user not being found in the repository
        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.empty());

        // Expect an exception to be thrown
        UserException exception = Assertions.assertThrows(UserException.class, () -> {
            userServiceImp.deleteById(userId);
        });

        // Assert the exception message
        Assertions.assertEquals("User not found for the Id:" + userId, exception.getMessage());


    }
    //Test For getall method
    @Test
    public void test_getAll_Success() {
        int pageNumber = 0;
        int pageSize = 5;

        // Mock the PageRequest and Page result
        List<User> userList = Arrays.asList(
                new User(1, "John", "john@example.com", "Male", new ArrayList<>(), new ArrayList<>()),
                new User(2, "Jane", "jane@example.com", "Female", new ArrayList<>(), new ArrayList<>())
        );
        Page<User> userPage = new PageImpl<>(userList);

        Mockito.when(userRepository.findAll(PageRequest.of(pageNumber, pageSize))).thenReturn(userPage);

        // Call the getAll method
        Page<User> result = userServiceImp.getAll(pageNumber, pageSize);

        // Assertions
        Assertions.assertNotNull(result);
        Assertions.assertEquals(2, result.getContent().size());
        Assertions.assertEquals("John", result.getContent().get(0).getName());
        Assertions.assertEquals("jane@example.com", result.getContent().get(1).getEmail());

        // Verify that findAll was called on the repository
        Mockito.verify(userRepository, Mockito.times(1)).findAll(PageRequest.of(pageNumber, pageSize));
    }
}
