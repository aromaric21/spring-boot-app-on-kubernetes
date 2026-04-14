package com.anr.book_management.services;

import com.anr.book_management.entities.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();
    Book getOneBook(String id);
    Book saveBook(Book book);
    Book updateBook(Book book);
    void deleteBook(String id);
}
