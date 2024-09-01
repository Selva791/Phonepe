package com.orderManagementSystem;

import com.orderManagementSystem.Inventory;
import com.orderManagementSystem.Seller;

public class InternalInventory extends Inventory {
    InventoryType inventoryType;
    public InternalInventory(String itemId, int quantity, Price price,InventoryType inventoryType,Seller seller) {
        super(itemId, quantity, price,seller);
        this.inventoryType=inventoryType;
    }

}
