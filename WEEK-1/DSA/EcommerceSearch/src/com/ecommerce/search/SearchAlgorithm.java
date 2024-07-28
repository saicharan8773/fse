package com.ecommerce.search;

public interface SearchAlgorithm {
    Product search(Product[] products, String targetName);
}
