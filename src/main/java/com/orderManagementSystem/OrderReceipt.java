package com.orderManagementSystem;

public class OrderReceipt {
    Order order;
    PaymentDetails paymentDetails;

    public OrderReceipt(Order order, PaymentDetails paymentDetails) {
        this.order = order;
        this.paymentDetails = paymentDetails;
    }

    public Order getOrder() {
        return order;
    }

    public PaymentDetails getPaymentDetails() {
        return paymentDetails;
    }
}
