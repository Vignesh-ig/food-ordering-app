package com.order.response;

import com.order.enums.USER_ROLE;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthResponse {

    private String jwt;
    private String message;
    private USER_ROLE userRole;

    public static AuthResponse buildAuthResponse(String jwt, String message, USER_ROLE userRole) {
        return AuthResponse.builder()
                .jwt(jwt)
                .message(message)
                .userRole(userRole)
                .build();
    }
}
