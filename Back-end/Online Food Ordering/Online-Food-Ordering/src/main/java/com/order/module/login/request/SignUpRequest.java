package com.order.module.login.request;

import com.order.Utils.RegexPattern;
import com.order.enums.USER_ROLE;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record SignUpRequest(

        @NotBlank(message = "Full Name cannot be blank")
        String fullName,

        @NotNull(message = "Email cannot be null")
        @Email(message = "Email should be valid")
        String email,

        @NotBlank
        @Pattern(regexp = RegexPattern.PASSWORD, message = "Password must be at least 8 characters long, contain at least one uppercase letter, one number, and one special character.")
        String password,

        @NotNull(message = "User Role cannot be blank")
        USER_ROLE userRole
) {
}
