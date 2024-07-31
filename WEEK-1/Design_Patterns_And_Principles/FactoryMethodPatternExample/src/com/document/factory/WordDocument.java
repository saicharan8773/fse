	package com.document.factory;

public class WordDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Word Document Factory  Method Pattern.");
    }

    @Override
    public void close() {
        System.out.println("Closing Word Document Factory  Method Pattern.");
    }

    @Override
    public void save() {
        System.out.println("Saving Word Document Factory  Method Pattern.");
    }
}
