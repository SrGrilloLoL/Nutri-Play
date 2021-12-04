package com.example.inicio.api.models;

public class LoginFailed {

    private String message;

    public LoginFailed() {
    }

    public LoginFailed(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
