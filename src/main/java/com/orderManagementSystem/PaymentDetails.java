package com.orderManagementSystem;

public class PaymentDetails {
    String paymentId;
    PaymentStatus paymentStatus;

    public PaymentDetails(String paymentId, PaymentStatus paymentStatus) {
        this.paymentId = paymentId;
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }
}
