package com.observer;

public class MobileApp implements Observer {
    @Override
    public void update(double price) {
        System.out.println("MobileApp: Stock price updated to " + price);
    }
}
