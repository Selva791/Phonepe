package com.orderManagementSystem;


public class ExternalInventory  extends Inventory {
    InventoryType inventoryType;
    public ExternalInventory(String itemId, int quantity,Price price, InventoryType inventoryType, Seller seller) {
        super(itemId,quantity,price, seller);
        this.inventoryType=inventoryType;
    }

}
