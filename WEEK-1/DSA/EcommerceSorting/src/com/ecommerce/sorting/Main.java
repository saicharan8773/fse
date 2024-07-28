package com.ecommerce.sorting;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Order[] orders = {
            new Order(1, "Alice", 250.0),
            new Order(2, "Bob", 150.0),
            new Order(3, "Charlie", 300.0),
            new Order(4, "David", 200.0)
        };

        // Using Bubble Sort
        SortAlgorithm bubbleSort = new BubbleSort();
        SortingService sortingService = new SortingService(bubbleSort);
        sortingService.sortOrders(orders);
        System.out.println("Sorted using Bubble Sort: " + Arrays.toString(orders));

        // Using Quick Sort
        SortAlgorithm quickSort = new QuickSort();
        sortingService = new SortingService(quickSort);
        sortingService.sortOrders(orders);
        System.out.println("Sorted using Quick Sort: " + Arrays.toString(orders));
    }
}
