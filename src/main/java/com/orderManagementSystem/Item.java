package com.orderManagementSystem;

public class Item {
    String id;
    String name;
    Price price;

    String description;
    ItemStatus itemStatus;
    String  sellerId;

    public Item(String id, String name, Price price, String description, ItemStatus itemStatus, String sellerId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.itemStatus = itemStatus;
        this.sellerId = sellerId;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Price getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public ItemStatus getItemStatus() {
        return itemStatus;
    }

    public String getSellerId() {
        return sellerId;
    }
}
