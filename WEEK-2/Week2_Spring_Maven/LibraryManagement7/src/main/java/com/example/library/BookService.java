package com.example.library;

public class BookService {
    private BookRepository bookRepository;

    // Constructor for constructor injection
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookService: Constructor injection");
    }

    // Setter for setter injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookService: Setter injection");
    }

    public void addBook(String title) {
        bookRepository.addBook(title);
    }

    public void listBooks() {
        bookRepository.listBooks();
    }
}