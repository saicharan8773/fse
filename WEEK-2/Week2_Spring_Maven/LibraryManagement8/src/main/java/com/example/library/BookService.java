package com.example.library;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private List<String> books = new ArrayList<>();

    public void addBook(String book) {
        books.add(book);
        System.out.println("Book added: " + book);
    }

    public void listBooks() {
        System.out.println("Listing books:");
        for (String book : books) {
            System.out.println(book);
        }
    }
}
