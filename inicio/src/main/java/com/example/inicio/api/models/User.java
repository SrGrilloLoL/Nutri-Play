package com.example.inicio.api.models;

public class User {

    private int userId;
    private String gender;
    private String username;
    private int age;
    private float height;
    private float weight;
    private String physicActivity;
    private String physicalActivityFrecuency;

    public User() {}

    public User(int userId, String gender, String username,int age, float height, float weight, String physicActivity, String physicalActivityFrecuency) {
        this.userId = userId;
        this.gender = gender;
        this.username = username;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.physicActivity = physicActivity;
        this.physicalActivityFrecuency = physicalActivityFrecuency;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getPhysicActivity() {
        return physicActivity;
    }

    public void setPhysicActivity(String physicActivity) {
        this.physicActivity = physicActivity;
    }

    public String getPhysicalActivityFrecuency() {
        return physicalActivityFrecuency;
    }

    public void setPhysicalActivityFrecuency(String physicalActivityFrecuency) {
        this.physicalActivityFrecuency = physicalActivityFrecuency;
    }
}
