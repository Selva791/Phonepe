package com.orderManagementSystem.service;

import com.orderManagementSystem.*;
import com.orderManagementSystem.dao.DataStore;

import java.util.List;
import java.util.UUID;

public class OrderService implements IOrderService {
    @Override
    public OrderReceipt createOrder(String customerId, List<Item> itemList, String address) {
        if(itemList!=null && itemList.size()==0){
                throw new RuntimeException("No Items found");
        }
        String orderId = UUID.randomUUID().toString();
        String sellerId=itemList.get(0).getSellerId();
        for(Item item:itemList){
            if(!sellerId.equals(sellerId)){
                throw new IllegalArgumentException("Seller is different");
            }
        }
        Order order=new Order(orderId,OrderStatus.PENDIND,itemList,address);
        DataStore.orderMap.put(orderId,order);
        System.out.println("Order created Successfully and Payment Initialized");
        PaymentDetails paymentDetails =new PaymentDetails(UUID.randomUUID().toString(),PaymentStatus.INITIALIZED);
        OrderReceipt orderReceipt =new OrderReceipt(order,paymentDetails);
        return orderReceipt;
    }

    @Override
    public boolean updateOrder(String orderId, OrderStatus orderStatus) {
        if(DataStore.orderMap.get(orderId)==null){
            System.out.println("Order id not found");
            return  false;
        }
        Order order = DataStore.orderMap.get(orderId);
        order.setOrderStatus(orderStatus);

        return true;
    }
}
