package com.anr.book_management.controllers;

import com.anr.book_management.entities.Book;
import com.anr.book_management.services.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity <List<Book>> getAllBooks(){
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneBook(@PathVariable String id){

        Book book = bookService.getOneBook(id);
        if (book == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Book with Id" + id + "not found");
        }
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createBook(@RequestBody @Valid Book book){
        bookService.saveBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body("Book added successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBook(@PathVariable String id, @RequestBody Book book){
        Book existing = bookService.getOneBook(id);
        if (existing == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found!");
        }
        bookService.updateBook(book);
        return ResponseEntity.ok().body(" Book updated!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable String id){
        Book existing = bookService.getOneBook(id);
        if (existing == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found!");
        }
        return ResponseEntity.ok("Book deleted!");
    }
}
