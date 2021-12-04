package com.example.inicio.api.models;

public class LoginDto {

    private String usernameOrEmail;
    private String password;

    public LoginDto(String usernameOrEmail, String password) {
        this.usernameOrEmail = usernameOrEmail;
        this.password = password;
    }


}
