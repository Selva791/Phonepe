package com.project;

import lombok.ToString;

@ToString
public class BookTable {
    int table;

    public int getTable() {
        return table;
    }

    public void setTable(int table) {
        this.table = table;
    }

    Restaurant restaurant;
    UserInfo userInfo;
    int peopleCount;

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
    }
}
