package com.proxy;

public class ProxyImage implements Image {
    private RealImage realImage;
    private String imageFileName;

    public ProxyImage(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(imageFileName);
        }
        realImage.display();
    }
}
