package com.singleton;

public class LoggerTest {
    public static void main(String[] args) {
        // Obtain instances of Logger
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Test if both references point to the same instance
        if (logger1 == logger2) {
            System.out.println("Logger instances are the same.");
        } else {
            System.out.println("Logger instances are different.");
        }

        // Log some messages
        logger1.log("This is a message from logger1.");
        logger2.log("This is a message from logger2.");
    }
}
