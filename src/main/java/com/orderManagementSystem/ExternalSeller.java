package com.orderManagementSystem;

import java.util.List;

public class ExternalSeller extends Seller{
    SellerType sellerType;
    public ExternalSeller(String id, String name, List<Item> itemList, SellerType sellerType) {
        super(id, name, itemList);
        this.sellerType=sellerType;
    }
}
