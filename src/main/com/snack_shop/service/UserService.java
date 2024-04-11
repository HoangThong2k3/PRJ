package com.snack_shop.service;

import com.snack_shop.dto.request.user.LoginRequestDto;
import com.snack_shop.dto.request.user.RegisterRequestDto;
import com.snack_shop.dto.request.user.UpdateRequestDto;
import com.snack_shop.dto.response.user.UserResponseDto;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    public boolean register(RegisterRequestDto registerRequestDto) throws SQLException;

    public UserResponseDto login(LoginRequestDto loginRequestDto) throws SQLException;

    public List<UserResponseDto> getAllUsers(String searchValue) throws SQLException;

    public List<UserResponseDto> getUserByName(String name) throws SQLException;

    public boolean deleteUser(String username) throws SQLException;

    public boolean updateUser(UpdateRequestDto user) throws SQLException;
}
