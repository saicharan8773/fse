package com.example.librarymanagement;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService bookService = context.getBean(BookService.class);

        // Test the service with AOP
        bookService.addBook("Spring in Action");
        bookService.addBook("Effective Java");
        bookService.listBooks();
    }
}
