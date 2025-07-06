package com.matchgo.quedamos.dto;

import com.matchgo.quedamos.model.User;

public class UserResponse {
    private String fullName;
    private String email;
    private String city;
    private String bio;

    public UserResponse(User user) {
        this.fullName = user.getFullName();
        this.email = user.getEmail();
        this.city = user.getCity();
        this.bio = user.getBio();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}