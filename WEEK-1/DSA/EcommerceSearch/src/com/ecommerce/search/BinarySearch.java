package com.ecommerce.search;

public class BinarySearch implements SearchAlgorithm {
    @Override
    public Product search(Product[] products, String targetName) {
        int left = 0;
        int right = products.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int comparison = products[mid].getProductName().compareToIgnoreCase(targetName);
            if (comparison == 0) {
                return products[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}
