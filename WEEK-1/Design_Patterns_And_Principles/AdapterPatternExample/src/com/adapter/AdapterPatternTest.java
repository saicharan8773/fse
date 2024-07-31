package com.adapter;

public class AdapterPatternTest {
    public static void main(String[] args) {
        // Create instances of payment gateways
        PayPalPaymentGateway payPalGateway = new PayPalPaymentGateway();
        StripePaymentGateway stripeGateway = new StripePaymentGateway();
        SquarePaymentGateway squareGateway = new SquarePaymentGateway();
        PaymentProcessor payPalAdapter = new PayPalAdapter(payPalGateway);
        PaymentProcessor stripeAdapter = new StripeAdapter(stripeGateway);
        PaymentProcessor squareAdapter = new SquareAdapter(squareGateway);
        payPalAdapter.processPayment(100.0);
        stripeAdapter.processPayment(150.0);
        squareAdapter.processPayment(200.0);
    }
}
