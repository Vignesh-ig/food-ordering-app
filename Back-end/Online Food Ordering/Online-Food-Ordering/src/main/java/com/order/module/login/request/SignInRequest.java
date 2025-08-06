package com.order.module.login.request;

import com.order.Utils.RegexPattern;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record SignInRequest(

        @NotBlank(message = "Email cannot be blank")
        @Email(message = "Email should be valid")
        String email,

        @NotBlank(message = "Password cannot be blank")
        @Pattern(regexp = RegexPattern.PASSWORD,
                message = "Password must be at least 8 characters long, contain at least one uppercase letter, one number, and one special character.")
        String password

) {}
