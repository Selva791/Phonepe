package com.orderManagementSystem;

public abstract class Inventory {
    String itemId;
    int quantity;
    Price price;
    Seller seller;

    public Inventory(String itemId, int quantity, Price price, Seller seller) {
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.seller = seller;
    }

    public String getItemId() {
        return itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public Price getPrice() {
        return price;
    }

    public Seller getSeller() {
        return seller;
    }
}
