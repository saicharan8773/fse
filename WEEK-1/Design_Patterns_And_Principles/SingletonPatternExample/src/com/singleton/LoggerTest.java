package com.singleton;

public class LoggerTest {
    public static void main(String[] args) {
        LoggerFactory factory = LoggerFactory.getInstance();

        Logger consoleLogger = factory.getLogger("console");
        Logger fileLogger = factory.getLogger("file");

        System.out.println(consoleLogger == ConsoleLogger.getInstance());
        System.out.println(fileLogger == FileLogger.getInstance());

        consoleLogger.log("Message for console logger.");
        fileLogger.log("Message for file logger.");
    }
}
