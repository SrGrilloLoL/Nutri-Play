package com.example.inicio.api.models;

public class UserDto {

    private String username;
    private String password;
    private int age;
    private int height;
    private int weight;
    private int genderId;
    private int physicalActivityId;
    private int physicalActivityFrecuencyId;

    public UserDto() {
    }

    public UserDto(String username, String password, int age, int height, int weight, int genderId, int physicalActivityId, int physicalActivityFrecuencyId) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.genderId = genderId;
        this.physicalActivityId = physicalActivityId;
        this.physicalActivityFrecuencyId = physicalActivityFrecuencyId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getGenderId() {
        return genderId;
    }

    public void setGenderId(int genderId) {
        this.genderId = genderId;
    }

    public int getPhysicalActivityId() {
        return physicalActivityId;
    }

    public void setPhysicalActivityId(int physicalActivityId) {
        this.physicalActivityId = physicalActivityId;
    }

    public int getPhysicalActivityFrecuencyId() {
        return physicalActivityFrecuencyId;
    }

    public void setPhysicalActivityFrecuencyId(int physicalActivityFrecuencyId) {
        this.physicalActivityFrecuencyId = physicalActivityFrecuencyId;
    }
}
