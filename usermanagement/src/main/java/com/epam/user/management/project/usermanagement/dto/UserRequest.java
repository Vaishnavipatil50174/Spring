package com.epam.user.management.project.usermanagement.dto;


import com.epam.user.management.project.usermanagement.model.Address;
import com.epam.user.management.project.usermanagement.model.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.Set;

@Data
public class UserRequest {
    @NotBlank(message = "name is Mandatory")
    String name;
    @NotEmpty(message = "Address not be null")
    Set<Address> addresses;
    @NotEmpty(message = "Role not be null")
    Set<Role> roles;
}
