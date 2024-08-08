package com.example.librarymanagement;

public class BookService {
    private BookRepository bookRepository;

    // Setter method for BookRepository
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Getter method for BookRepository (for testing purposes)
    public BookRepository getBookRepository() {
        return this.bookRepository;
    }

    // Other methods...
}