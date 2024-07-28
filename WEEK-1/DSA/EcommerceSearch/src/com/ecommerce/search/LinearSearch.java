package com.ecommerce.search;

public class LinearSearch implements SearchAlgorithm {
    @Override
    public Product search(Product[] products, String targetName) {
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(targetName)) {
                return product;
            }
        }
        return null;
    }
}
