package com.orderManagementSystem;

import java.util.List;

public class Order {
    String id;
    OrderStatus orderStatus;
    List<Item> itemList;
    String address;

    public Order(String id, OrderStatus orderStatus, List<Item> itemList, String address) {
        this.id = id;
        this.orderStatus = orderStatus;
        this.itemList = itemList;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public String getAddress() {
        return address;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
