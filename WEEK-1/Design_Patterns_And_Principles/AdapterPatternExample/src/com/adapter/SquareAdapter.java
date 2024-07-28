package com.adapter;

public class SquareAdapter implements PaymentProcessor {
    private SquarePaymentGateway squarePaymentGateway;

    public SquareAdapter(SquarePaymentGateway squarePaymentGateway) {
        this.squarePaymentGateway = squarePaymentGateway;
    }

    @Override
    public void processPayment(double amount) {
        squarePaymentGateway.pay(amount);
    }
}
