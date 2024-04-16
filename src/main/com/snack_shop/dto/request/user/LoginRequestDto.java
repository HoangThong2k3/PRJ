package com.snack_shop.dto.request.user;

import lombok.Getter;

@Getter
public class LoginRequestDto {
    private String username;
    private String password;

    public LoginRequestDto() {
    }

    public LoginRequestDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
