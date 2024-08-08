package com.ex9.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ex9.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
