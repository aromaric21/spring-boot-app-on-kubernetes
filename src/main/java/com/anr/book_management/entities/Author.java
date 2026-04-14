package com.anr.book_management.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Document(collection = "authors")
@Data
@AllArgsConstructor @NoArgsConstructor
public class Author {

    @Id
    private String id;
    private String name;
    private String email;
}
