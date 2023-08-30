package com.project;

import lombok.ToString;

@ToString
public class UserInfo {
    String userName;
    int userId;
    String phone;
    String email;

    public String getUserName() {
        return userName;
    }

    public int getUserId() {
        return userId;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getLocation() {
        return location;
    }

    String location;


    public UserInfo(String userName, String phone, String email, String location) {
        this.userName = userName;
        this.phone = phone;
        this.email = email;
        this.location = location;
    }

}
