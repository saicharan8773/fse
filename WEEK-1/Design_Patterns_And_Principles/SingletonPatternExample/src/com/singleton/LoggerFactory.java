package com.singleton;

public class LoggerFactory {
    private static LoggerFactory instance;

    private LoggerFactory() {
    }

    public static synchronized LoggerFactory getInstance() {
        if (instance == null) {
            instance = new LoggerFactory();
        }
        return instance;
    }

    public Logger getLogger(String type) {
        if (type.equalsIgnoreCase("console")) {
            return ConsoleLogger.getInstance();
        } else if (type.equalsIgnoreCase("file")) {
            return FileLogger.getInstance();
        }
        throw new IllegalArgumentException("Charan Invalid logger type specified.");
    }
}
