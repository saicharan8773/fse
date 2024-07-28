package com.observer;

public class ObserverPatternTest {
    public static void main(String[] args) {
        // Create stock market (subject)
        StockMarket stockMarket = new StockMarket();

        // Create observers
        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        // Register observers
        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        // Change stock price
        stockMarket.setPrice(150.00);
        stockMarket.setPrice(155.50);

        // Deregister an observer and change the price
        stockMarket.deregisterObserver(mobileApp);
        stockMarket.setPrice(160.00);
    }
}
