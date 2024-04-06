package com.snack_shop.service.impl;

import com.snack_shop.service.AuthService;

public class AuthServiceImpl implements AuthService {
    public boolean register(RegisterRequestDto registerRequestDto) throws SQLException {
        // Register the user
        return true;
    }

    public LoginResponseDto login(LoginRequestDto loginRequestDto) throws SQLException {
        // Login the user
        return new LoginResponseDto();
    }

    public UserResponseDto getUserInfo(int id) {
        // Get the user info
        return new UserResponseDto();
    }
}
