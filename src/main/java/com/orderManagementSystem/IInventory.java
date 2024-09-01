package com.orderManagementSystem;

public interface IInventory {
    public  boolean addItemToInventory(String itemId, int quantity, Price price);
    public  int getAvailableInventory(String itemId, Seller seller);
}
