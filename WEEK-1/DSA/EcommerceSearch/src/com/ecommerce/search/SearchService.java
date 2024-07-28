package com.ecommerce.search;

public class SearchService {
    private final SearchAlgorithm searchAlgorithm;

    public SearchService(SearchAlgorithm searchAlgorithm) {
        this.searchAlgorithm = searchAlgorithm;
    }

    public Product findProduct(Product[] products, String targetName) {
        return searchAlgorithm.search(products, targetName);
    }
}
