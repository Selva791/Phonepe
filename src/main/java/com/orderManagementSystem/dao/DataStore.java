package com.orderManagementSystem.dao;

import com.orderManagementSystem.Inventory;
import com.orderManagementSystem.Item;
import com.orderManagementSystem.Order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataStore {
    static public Map<String, Item> itemMap=new HashMap<>();
    static public  Map<String, List<Inventory>> inventoryMap=new HashMap<>();
    static public  Map<String, Order> orderMap=new HashMap<>();
}
