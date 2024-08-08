package com.example.librarymanagement;

//package com.example.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService bookService = context.getBean(BookService.class);

        // Test the service
        bookService.addBook("Spring in Action");
        bookService.addBook("Effective Java");
        bookService.listBooks();
    }
}