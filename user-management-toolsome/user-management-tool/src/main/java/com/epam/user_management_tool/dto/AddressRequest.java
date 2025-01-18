package com.epam.user_management_tool.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddressRequest {
    @NotBlank(message = "Address type can not be NULL")
    private String addressName;

    @NotBlank(message = "Address type can not be NULL")
    private String addressType;

    @NotBlank(message = "Address city can not be NULL")
    private String addressCity;
}
