package com.document.factory;

public class ExcelDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Excel Document Factory  Method Pattern.");
    }

    @Override
    public void close() {
        System.out.println("Closing Excel Document Factory  Method Pattern.");
    }

    @Override
    public void save() {
        System.out.println("Saving Excel Document Factory  Method Pattern.");
    }
}
