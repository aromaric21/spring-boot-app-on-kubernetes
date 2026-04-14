package com.anr.book_management.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Builder
@Document(collection = "books")
@Data
@AllArgsConstructor @NoArgsConstructor
public class Book {

    @Id
    private String id;
    private String title;
    private String isbn;
    private String description;
    private Integer page;
    private BigDecimal price;
    private String authorId;

}
