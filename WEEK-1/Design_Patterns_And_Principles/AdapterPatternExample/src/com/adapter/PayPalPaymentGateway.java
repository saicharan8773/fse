package com.adapter;

public class PayPalPaymentGateway {
    public void makePayment(double amount) {
        System.out.println("Processing payment of $" + amount + " through PayPal.");
    }
}
