package com.document.factory;

public class PdfDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening PDF Document Factory  Method Pattern.");
    }

    @Override
    public void close() {
        System.out.println("Closing PDF Document Factory  Method Pattern.");
    }

    @Override
    public void save() {
        System.out.println("Saving PDF Document Factory  Method Pattern.");
    }
}
