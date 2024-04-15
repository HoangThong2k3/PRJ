package com.snack_shop.dto.request.user;

import com.snack_shop.utils.HashTokenGenerator;
import org.mindrot.jbcrypt.BCrypt;

public class LoginRequestDto {
    private String username;
    private String password;

    public LoginRequestDto() {
    }

    public LoginRequestDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
}
