package com.project;

public class Cuisine implements FoodMenu{
    String name;
    String taste;
    String type;
    ServedTime timeServed;
    Cost cost;

    public void setName(String name) {
        this.name = name;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTimeServed(ServedTime timeServed) {
        this.timeServed = timeServed;
    }

    public void setCost(Cost cost) {
        this.cost = cost;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getTaste() {
        return taste;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public ServedTime getTimeServed() {
        return timeServed;
    }

    @Override
    public Cost getCost() {
        return cost;
    }
}
