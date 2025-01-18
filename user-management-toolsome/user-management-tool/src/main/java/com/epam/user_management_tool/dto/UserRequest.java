package com.epam.user_management_tool.dto;

import com.epam.user_management_tool.entity.Address;
import com.epam.user_management_tool.entity.Role;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor

@Data
public class UserRequest {
    private Integer id;

    @NotNull(message = "Name must not be null")
    @Pattern(regexp = "^[A-Za-z]+$", message = "Name must contain only letters and no digits")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @NotBlank(message = "User email is mandatory")
    private String email;

    @NotBlank(message = "Gender is mandatory")
    @Pattern(regexp = "^(Male|Female|Other)$", message = "Gender must be Male, Female, or Other")
    private String gender;

    @NotEmpty(message = "Address is mandatory")
    @Valid
    private List<AddressRequest> addresses;
    @NotEmpty(message = "Role is mandatory")
    @Valid
    private List<RoleRequest> roles;

}
