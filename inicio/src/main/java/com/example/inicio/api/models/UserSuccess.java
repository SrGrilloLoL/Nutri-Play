package com.example.inicio.api.models;

public class UserSuccess {

    private String message;

    public UserSuccess() {
    }

    public UserSuccess(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
