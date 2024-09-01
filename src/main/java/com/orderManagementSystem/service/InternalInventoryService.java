package com.orderManagementSystem.service;

import com.orderManagementSystem.IInventory;
import com.orderManagementSystem.Price;
import com.orderManagementSystem.Seller;

public class InternalInventoryService implements IInventory {
    @Override
    public boolean addItemToInventory(String itemId, int quantity, Price price) {
        return false;
    }

    @Override
    public int getAvailableInventory(String itemId, Seller seller) {
        return 0;
    }
}
