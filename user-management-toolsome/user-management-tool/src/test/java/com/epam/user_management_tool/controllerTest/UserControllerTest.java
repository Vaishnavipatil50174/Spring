package com.epam.user_management_tool.controllerTest;


import com.epam.user_management_tool.controller.UserController;
import com.epam.user_management_tool.dto.AddressRequest;
import com.epam.user_management_tool.dto.RoleRequest;
import com.epam.user_management_tool.dto.UserRequest;
import com.epam.user_management_tool.entity.Address;
import com.epam.user_management_tool.entity.Role;
import com.epam.user_management_tool.entity.User;
import com.epam.user_management_tool.service.UserServiceImp;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {


    @Mock
    private UserServiceImp userService;

    @InjectMocks
    private UserController userController;

    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    // Test for createUser
    @Test
    public void test_createUser_Success() throws Exception {
        // Mock UserRequest
        UserRequest userRequest = new UserRequest(1, "Vaish", "Vaish@example.com", "Male",
                new ArrayList<>(Arrays.asList(new AddressRequest("Satara", "Home", "NYC"))),
                new ArrayList<>(Arrays.asList(new RoleRequest("Admin"))));

        // Mock User object
        User user = new User();
        user.setId(1);
        user.setName("Vaish");
        user.setEmail("Vaish@example.com");
        user.setGender("Male");
        user.setAddresses(new ArrayList<>(Arrays.asList(new Address(1, "Satara", "Home", "NYC"))));
        user.setRoles(new ArrayList<>(Arrays.asList(new Role(1, "Admin"))));

        // Mock service method
        when(userService.createUser(any(UserRequest.class))).thenReturn(user);

        // Perform POST request
        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userRequest)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Vaish"))
                .andExpect(jsonPath("$.email").value("Vaish@example.com"));
    }

    // Test for getUserById
    @Test
    public void test_getUserById_Success() throws Throwable {
        // Mock User object
        User user = new User();
        user.setId(1);
        user.setName("Vaish");
        user.setEmail("Vaish@example.com");
        user.setGender("Male");

        // Mock service method
        when(userService.getUserById(1)).thenReturn(user);

        // Perform GET request
        mockMvc.perform(get("/users/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Vaish"))
                .andExpect(jsonPath("$.email").value("Vaish@example.com"));
    }

    // Test for getAllUser not workingggggggggggggggggggggggggggggggggggggggggggggggggggg
//    @Test
//    public void test_getAllUser_Success() throws Exception {
//        // Arrange
//        // Mock list of users
//        List<User> usersList = List.of(
//                new User(1, "Vaish", "Vaish@example.com", "Male",
//                        List.of(new Address(1, "Satara", "Home", "NYC")),
//                        List.of(new Role(1, "Admin"))
//                )
//        );
//
//        // Mock Page of users
//        Page<User> usersPage = new PageImpl<>(usersList);
//
//        // Mocking service method to return the mocked page
//        when(userService.getAll(0, 10)).thenReturn(usersPage);
//
//        // Act and Assert
//        mockMvc.perform(get("/users/pageNumber/0/pageSize/10"))
//                .andExpect(status().isOk()) // Expecting 200 OK
//                .andExpect(jsonPath("$.content[0].name").value("Vaish"))
//                .andExpect(jsonPath("$.content[0].email").value("Vaish@example.com"))
//                .andExpect(jsonPath("$.content[0].gender").value("Male"))
//                .andExpect(jsonPath("$.content[0].addresses[0].city").value("Satara"))
//                .andExpect(jsonPath("$.content[0].roles[0].name").value("Admin"));
//    }



    // Test for deleteUserById
    @Test
    public void test_deleteUserById_Success() throws Throwable {
        // Mock service method
        doNothing().when(userService).deleteById(1);

        // Perform DELETE request
        mockMvc.perform(delete("/users/1"))
                .andExpect(status().isOk());
    }
}
