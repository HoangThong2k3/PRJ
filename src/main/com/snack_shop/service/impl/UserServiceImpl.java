package com.snack_shop.service.impl;

import com.snack_shop.dto.request.user.LoginRequestDto;
import com.snack_shop.dto.request.user.RegisterRequestDto;
import com.snack_shop.dto.response.user.UserResponseDto;
import com.snack_shop.repository.UserRepository;
import com.snack_shop.service.UserService;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserRepository UserRepository = new UserRepository();

    @Override
    public boolean register(RegisterRequestDto registerRequestDto) throws SQLException{
        return UserRepository.registerUser(registerRequestDto);
    }

    @Override
    public UserResponseDto login(LoginRequestDto loginRequestDto) throws SQLException {
        return UserRepository.validateLogin(loginRequestDto);
    }

    @Override
    public List<UserResponseDto> getAllUsers() throws SQLException {
        return UserRepository.getAllUsers();
    }

}
