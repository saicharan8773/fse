package com.singleton;

public class Logger {
    // Volatile keyword ensures visibility of changes to variables across threads
    private static volatile Logger instance;

    // Private constructor to prevent instantiation
    private Logger() {
    }

    // Public method to provide access to the single instance
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    // Example method to demonstrate logging functionality
    public void log(String message) {
        System.out.println("Log: " + message);
    }
}
