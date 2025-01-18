package com.epam.user_management_tool.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class RoleRequest {
    @NotNull(message = "Role name Must be Mentioned")
    private String role;
}

