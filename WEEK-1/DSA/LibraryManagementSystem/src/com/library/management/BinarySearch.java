package com.library.management;

import java.util.Arrays;

public class BinarySearch implements SearchAlgorithm {
    @Override
    public Book search(Book[] books, String searchTerm) {
        int low = 0;
        int high = books.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            Book midBook = books[mid];

            if (midBook.getTitle().equalsIgnoreCase(searchTerm) || midBook.getAuthor().equalsIgnoreCase(searchTerm)) {
                return midBook;
            } else if (midBook.getTitle().compareToIgnoreCase(searchTerm) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }
}
