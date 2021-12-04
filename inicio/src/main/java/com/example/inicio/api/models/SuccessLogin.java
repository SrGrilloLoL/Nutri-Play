package com.example.inicio.api.models;

public class SuccessLogin {

    private int statusCode;
    private String message;
    private Data data;


    public SuccessLogin() {}

    public SuccessLogin(int statusCode, String message, Data data) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public class Data{

        private String accessToken;
        private String username;
        private String role;
        private int userId;

        public Data() {}

        public Data(String accessToken, String username, String role,int userId) {
            this.accessToken = accessToken;
            this.username = username;
            this.userId = userId;
            this.role = role;
        }

        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }
    }

}

