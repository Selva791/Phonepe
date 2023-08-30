package com.project;

public class Cost {
    double totalAmount;
    double cuisineCost;
    double tax;

    public double getCuisineCost() {
        return cuisineCost;
    }

    public void setCuisineCost(double cuisineCost) {
        this.cuisineCost = cuisineCost;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

}
