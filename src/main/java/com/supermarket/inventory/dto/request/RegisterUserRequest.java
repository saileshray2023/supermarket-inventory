package com.supermarket.inventory.dto.request;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import com.supermarket.inventory.entity.Role;



@Getter
@Setter
public class RegisterUserRequest {

    @NotBlank(message = "username is required")
    @Size(min = 3, max = 50, message = "username must be between 3 and 50 characters")
    private String username;

    @NotBlank(message = "email is required")
    @Email(message = "email must be a valid email address")
    @Size(max = 150, message = "email must not exceed 150 characters")
    private String email;

    @NotBlank(message = "password is required")
    @Size(min = 8, max = 100, message = "password must be between 8 and 100 characters")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$",
            message = "password must contain at least one uppercase letter, one lowercase letter, and one digit"
    )
    private String password;


    @NotBlank(message = "full name is required")
    @Size(max = 150, message = "full name must not exceed 150 characters")
    private String fullName;

    @NotNull(message = "role is required")
    private Role role;
}