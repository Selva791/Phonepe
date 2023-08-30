package com.project;

import lombok.ToString;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;
import java.util.UUID;
@ToString
public class Restaurant {
    private UUID restaurantId= UUID.randomUUID();
    private String restaurantName;

    public String getRestaurantId() {
        return restaurantId.toString();
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public String getCity() {
        return city;
    }

    public String getArea() {
        return area;
    }

    public Set<Cuisine> getCuisineSet() {
        return cuisineSet;
    }

    public Set<LocalTime> getDateTimeAvailable() {
        return dateTimeAvailable;
    }

    public int getTotalTable() {
        return totalTable;
    }

    private String city;
    private String area;

    public Restaurant(String restaurantName,
                      String city,
                      String area,
                      Set<Cuisine> cuisineSet,
                      Set<LocalTime> dateTimeAvailable,
                      int totalTable) {
        this.restaurantName = restaurantName;
        this.city = city;
        this.area = area;
        this.cuisineSet = cuisineSet;
        this.dateTimeAvailable = dateTimeAvailable;
        this.totalTable = totalTable;
    }

    private Set<Cuisine> cuisineSet;
    private Set<LocalTime> dateTimeAvailable;
    private int totalTable;
}
