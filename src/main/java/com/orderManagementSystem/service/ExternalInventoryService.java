package com.orderManagementSystem.service;

import com.orderManagementSystem.*;
import com.orderManagementSystem.dao.DataStore;

import java.util.ArrayList;
import java.util.List;

public class ExternalInventoryService implements IInventory {
    @Override
    public boolean addItemToInventory(String itemId, int quantity, Price price) {

        if(itemId==null || itemId.equals("")) throw  new RuntimeException("Empty item ID");
        Seller seller =new InternalSeller("12","FlipKart", SellerType.INTERNAL);
        InternalInventory internalInventory=new InternalInventory(itemId,quantity,price,InventoryType.EXTERNAL,seller);
        DataStore.inventoryMap.computeIfAbsent(itemId,s->new ArrayList<>()).add(internalInventory);
        return true;
    }

    @Override
    public int getAvailableInventory(String itemId, Seller seller) {
        List<Inventory> inventoryList=DataStore.inventoryMap.get(itemId);
        int count=0;
        for(Inventory inventory:inventoryList){
                if(inventory.getSeller().getId()==seller.getId()){
                    count++;
                }
        }
        return count;
    }
}
