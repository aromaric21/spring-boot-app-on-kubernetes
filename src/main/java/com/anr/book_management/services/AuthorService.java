package com.anr.book_management.services;

import com.anr.book_management.entities.Author;

import java.util.List;

public interface AuthorService {

    List<Author> getAllAuthors();
    Author getOneAuthor(String id);
    Author saveAuthor(Author author);
    Author updateAuthor(Author author);
    void deleteAuthor(String id);

}
