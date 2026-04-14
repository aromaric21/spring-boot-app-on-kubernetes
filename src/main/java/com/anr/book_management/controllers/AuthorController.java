package com.anr.book_management.controllers;

import com.anr.book_management.entities.Author;
import com.anr.book_management.services.AuthorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthors(){
        return  new ResponseEntity<>(authorService.getAllAuthors(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneAuthor(@PathVariable String id){
        Author author = authorService.getOneAuthor(id);
        if (author == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Author with Id" + id + " not found");
        }
        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createAuthor(@RequestBody @Valid Author author){
        authorService.saveAuthor(author);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Author Inserted successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAuthor(@PathVariable String id, @RequestBody Author author){
        Author existingAuthor = authorService.getOneAuthor(id);
        if (existingAuthor == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Author with Id not found!");
        }
        authorService.updateAuthor(author);
        return ResponseEntity.ok().body("Author updated!");
    }

   @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable String id){
        Author existingAuthor = authorService.getOneAuthor(id);
       if (existingAuthor == null){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found!");
       }
       return ResponseEntity.ok("Author deleted!");
   }

}
