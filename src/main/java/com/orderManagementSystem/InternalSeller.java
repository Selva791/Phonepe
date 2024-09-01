package com.orderManagementSystem;

import java.util.List;

public class InternalSeller extends Seller{
    SellerType sellerType;
    public InternalSeller(String id, String name,SellerType sellerType) {
        super(id, name);
        this.sellerType=sellerType;
    }
}
