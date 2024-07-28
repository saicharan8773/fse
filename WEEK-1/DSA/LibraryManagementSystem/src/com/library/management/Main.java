package com.library.management;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Book[] books = {
            new Book("1", "The Great Gatsby", "F. Scott FXJitzgerald"),
            new Book("2", "data structures", "Sai Charan"),
            new Book("3", "1984", "George Orwell"),
            new Book("4", "The Catcher in the Rye", "J.D. Salinger")
        };

        // Linear Search
        SearchAlgorithm linearSearch = new LinearSearch();
        System.out.println("Linear Search:");
        Book book1 = linearSearch.search(books, "1984");
        System.out.println(book1);

        // Binary Search
        Arrays.sort(books, (b1, b2) -> b1.getTitle().compareToIgnoreCase(b2.getTitle()));
        SearchAlgorithm binarySearch = new BinarySearch();
        System.out.println("\nBinary Search:");
        Book book2 = binarySearch.search(books, "The Catcher in the Rye");
        System.out.println(book2);
    }
}
