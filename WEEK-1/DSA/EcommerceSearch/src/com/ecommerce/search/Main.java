package com.ecommerce.search;

public class Main {
    public static void main(String[] args) {
        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Smartphone", "Electronics"),
            new Product(3, "Coffee Maker", "Home Appliances")
        };
        SearchAlgorithm linearSearch = new LinearSearch();
        SearchService searchService = new SearchService(linearSearch);
        
        Product result = searchService.findProduct(products, "Smartphone");
        if (result != null) {
            System.out.println("Product found: " + result.getProductName());
        } else {
            System.out.println("Product not found.");
        }
        SearchAlgorithm binarySearch = new BinarySearch();
        searchService = new SearchService(binarySearch);

        result = searchService.findProduct(products, "Laptop");
        if (result != null) {
            System.out.println("Product found: " + result.getProductName());
        } else {
            System.out.println("Product not found.");
        }
    }
}
