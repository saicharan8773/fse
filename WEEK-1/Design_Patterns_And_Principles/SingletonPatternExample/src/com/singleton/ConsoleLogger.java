package com.singleton;

public class ConsoleLogger implements Logger {
    private static volatile ConsoleLogger instance;

    private ConsoleLogger() {
    }

    public static ConsoleLogger getInstance() {
        if (instance == null) {
            synchronized (ConsoleLogger.class) {
                if (instance == null) {
                    instance = new ConsoleLogger();
                }
            }
        }
        return instance;
    }

    @Override
    public void log(String message) {
        System.out.println("Charan Console Log: " + message);
    }
}
