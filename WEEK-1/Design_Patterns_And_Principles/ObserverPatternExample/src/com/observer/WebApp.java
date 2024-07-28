package com.observer;

public class WebApp implements Observer {
    @Override
    public void update(double price) {
        System.out.println("WebApp: Stock price updated to " + price);
    }
}
