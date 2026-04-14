package com.anr.book_management.services.servicesImpl;

import com.anr.book_management.entities.Author;
import com.anr.book_management.repositories.AuthorRepository;
import com.anr.book_management.services.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author getOneAuthor(String id) {
        return authorRepository.findById(id).orElse(null);
    }

    @Override
    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author updateAuthor(Author author) {

        Author exstingAuthor = getOneAuthor(author.getId());

        exstingAuthor.setName(author.getName());
        exstingAuthor.setEmail(author.getEmail());

        return authorRepository.save(exstingAuthor);
    }

    @Override
    public void deleteAuthor(String id) {
        authorRepository.deleteById(id);
    }
}
