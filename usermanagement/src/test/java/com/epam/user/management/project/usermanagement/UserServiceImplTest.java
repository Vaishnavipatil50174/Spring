package com.epam.user.management.project.usermanagement;

import com.epam.user.management.project.usermanagement.model.Address;
import com.epam.user.management.project.usermanagement.model.Role;
import com.epam.user.management.project.usermanagement.model.User;
import com.epam.user.management.project.usermanagement.repository.UserRepo;
import com.epam.user.management.project.usermanagement.service.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @Mock
    UserRepo userRepo;

    @InjectMocks
    UserServiceImpl userServiceImpl;

    @Test
    public void tests(){
        User user=new User();
        user.setId(1);
        user.setName("vaish");
        user.setAddresses(new ArrayList<>(Arrays.asList(new Address(1, "Satara"))));
        user.setRoles(new ArrayList<>(Arrays.asList(new Role(1, "Admin"))));

        when(userRepo.findById(1)).thenReturn(Optional.of(user));

        Assertions.assertEquals("vaish", userServiceImpl.getById(1).getName());
    }
}
