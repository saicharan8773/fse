package com.singleton;

import java.io.*;

public class FileLogger implements Logger {
    private static FileLogger instance;
    private PrintWriter writer;

    private FileLogger() {
        try {
            writer = new PrintWriter(new FileWriter("application.log", true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static FileLogger getInstance() {
        if (instance == null) {
            synchronized (FileLogger.class) {
                if (instance == null) {
                    instance = new FileLogger();
                }
            }
        }
        return instance;
    }

    @Override
    public void log(String message) {
        writer.println("File Log: " + message);
        writer.flush();
    }
}
