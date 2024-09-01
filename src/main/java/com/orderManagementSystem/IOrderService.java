package com.orderManagementSystem;

import java.util.List;

public interface IOrderService {
    public OrderReceipt createOrder(String customerId, List<Item> itemList, String address);
   public boolean updateOrder(String orderId, OrderStatus orderStatus);
}
