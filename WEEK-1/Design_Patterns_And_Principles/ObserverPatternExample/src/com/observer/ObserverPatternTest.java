package com.observer;

public class ObserverPatternTest {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        stockMarket.setPrice(150.00);
        stockMarket.setPrice(155.50);

        stockMarket.deregisterObserver(mobileApp);
        stockMarket.setPrice(160.00);
    }
}
