package com.library.management;

public class LinearSearch implements SearchAlgorithm {
    @Override
    public Book search(Book[] books, String searchTerm) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(searchTerm) || book.getAuthor().equalsIgnoreCase(searchTerm)) {
                return book;
            }
        }
        return null;
    }
}
