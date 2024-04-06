package com.snack_shop.service;

public interface AuthService {
    public boolean register(RegisterRequestDto registerRequestDto) throws SQLException;

    public LoginResponseDto login(LoginRequestDto loginRequestDto) throws SQLException;

    public UserResponseDto getUserInfo(int id);
}
