package com.snack_shop.service;

import com.snack_shop.dto.request.user.LoginRequestDto;
import com.snack_shop.dto.request.user.RegisterRequestDto;
import com.snack_shop.dto.response.user.UserDto;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    public boolean register(RegisterRequestDto registerRequestDto) throws SQLException;

    public UserDto login(LoginRequestDto loginRequestDto) throws SQLException;

    public List<UserDto> getAllUsers() throws SQLException;
}
