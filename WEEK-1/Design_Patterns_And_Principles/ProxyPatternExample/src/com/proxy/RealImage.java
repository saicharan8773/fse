package com.proxy;

public class RealImage implements Image {
    private String imageFileName;

    public RealImage(String imageFileName) {
        this.imageFileName = imageFileName;
        loadImageFromServer();
    }

    private void loadImageFromServer() {
        System.out.println("Loading image: " + imageFileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + imageFileName);
    }
}
