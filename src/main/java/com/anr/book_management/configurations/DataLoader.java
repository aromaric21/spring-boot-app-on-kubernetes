package com.anr.book_management.configurations;

import com.anr.book_management.entities.Author;
import com.anr.book_management.entities.Book;
import com.anr.book_management.repositories.AuthorRepository;
import com.anr.book_management.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.UUID;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initDatabase(BookRepository bookRepository,
                                   AuthorRepository authorRepository){
        return args -> {
            // Génération des 50 auteurs si la collection est vide
            if (authorRepository.count() == 0) {
                for (int i = 1; i <= 50; i++) {
                    Author author = Author.builder()
                            .name("Author " + i)
                            .email("author" + i + "@example.com")
                            .build();
                    authorRepository.save(author);
                }
                System.out.println("✅ 50 auteurs insérés dans MongoDB !");
            }

            // Génération des 1000 livres si la collection est vide
            if (bookRepository.count() == 0){
                for (int i = 1; i <= 100; i++){
                    Book book = Book.builder()
                            .title("Book" + i)
                            .isbn("ISBN-" + UUID.randomUUID())
                            .description("Book description " + 1)
                            .page(150 + i)
                            .price(BigDecimal.valueOf(10 + (i % 50)))
                            .authorId("AUTH-" + (i % 50))
                            .build();
                    bookRepository.save(book);
                }
                System.out.println("100 books inserted in MongoDB!");
            }
        };
    }
}
