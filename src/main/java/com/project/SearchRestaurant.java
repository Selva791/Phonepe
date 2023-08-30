package com.project;

public class SearchRestaurant implements Search {
    private String city;
    private String area;
    private String cuisine;
    private int peopleCount;
    private Cost totalCost;

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    private String mealType;


    public void setCity(String city) {
        this.city = city;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public void setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
    }

    public void setTotalCost(Cost totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public String getArea() {
        return area;
    }

    @Override
    public String getCuisine() {
        return cuisine;
    }

    @Override
    public int getPeopleCount() {
        return peopleCount;
    }

    @Override
    public Cost getTotalCost() {
        return totalCost;
    }
}
