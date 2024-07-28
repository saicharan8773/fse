package com.ecommerce.sorting;

public class SortingService {
    private final SortAlgorithm sortAlgorithm;

    public SortingService(SortAlgorithm sortAlgorithm) {
        this.sortAlgorithm = sortAlgorithm;
    }

    public void sortOrders(Order[] orders) {
        sortAlgorithm.sort(orders);
    }
}
