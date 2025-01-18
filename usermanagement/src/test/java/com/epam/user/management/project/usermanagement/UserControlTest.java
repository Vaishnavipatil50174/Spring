package com.epam.user.management.project.usermanagement;

import com.epam.user.management.project.usermanagement.controller.UserController;
import com.epam.user.management.project.usermanagement.model.User;
import com.epam.user.management.project.usermanagement.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashSet;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControlTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserServiceImpl userServiceImpl;

    @Test
    public void test1() throws Exception{

        User user1 = new User();
        user1.setId(1);
        user1.setName("John");
        user1.setAddresses(new HashSet<>());
        user1.setRoles(new HashSet<>());

        when(userServiceImpl.getById(1)).thenReturn(user1);

        mockMvc.perform(get("/user/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John"));

    }

    @Test
    public void testDeleteUser() throws Exception {
        mockMvc.perform(delete("/user/1"))
                .andExpect(status().isOk());
    }


}
