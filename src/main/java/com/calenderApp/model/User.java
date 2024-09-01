package com.calenderApp.model;

import lombok.ToString;

@ToString
public class User {
    String id;
    String name;
    String company;
    String email;

    public User(String id, String name, String company, String email) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public String getEmail() {
        return email;
    }

}
