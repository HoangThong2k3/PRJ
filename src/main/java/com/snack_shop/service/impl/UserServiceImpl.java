package com.snack_shop.service.impl;

import com.snack_shop.dto.request.user.LoginRequestDto;
import com.snack_shop.dto.request.user.RegisterRequestDto;
import com.snack_shop.dto.response.user.UserDto;
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
    public UserDto login(LoginRequestDto loginRequestDto) throws SQLException {
        return UserRepository.validateLogin(loginRequestDto);
    }

    @Override
    public List<UserDto> getAllUsers() throws SQLException {
        return UserRepository.getAllUsers();
    }

}
