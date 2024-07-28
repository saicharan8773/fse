package com.strategy;

public class StrategyPatternTest {
    public static void main(String[] args) {
        // Creating different payment strategies
        PaymentStrategy creditCard = new CreditCardPayment("901466944444444", "SAI CHARAN");
        PaymentStrategy payPal = new PayPalPayment("saicharan8773@gmail.com");

        // Creating context with CreditCardPayment strategy
        PaymentContext context = new PaymentContext(creditCard);
        context.executePayment(100.00);

        // Switching to PayPalPayment strategy
        context = new PaymentContext(payPal);
        context.executePayment(200.00);
    }
}
