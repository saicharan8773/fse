package com.example.librarymanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private BookRepository bookRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookRepository getBookRepository() {
        return this.bookRepository;
    }

	public void addBook(String string) {
		// TODO Auto-generated method stub
		
	}

	public void listBooks() {
		// TODO Auto-generated method stub
		
	}

    // Other methods...
}