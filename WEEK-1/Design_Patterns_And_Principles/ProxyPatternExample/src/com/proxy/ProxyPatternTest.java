package com.proxy;

public class ProxyPatternTest {
    public static void main(String[] args) {
        // Update the path to your local image file
        String imagePath = "D:/JAVA FSE/WEEK-1/Design_Patterns_And_Principles/ProxyPatternExample/image.png";

        // Create proxy image object
        Image image = new ProxyImage(imagePath);

        // Display the image
        image.display();
    }
}
