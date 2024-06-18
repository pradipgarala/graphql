package com.example.graphql.repository;

import com.example.graphql.model.Book;
import com.example.graphql.model.Rating;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {
    private final AuthorRepository authorRepository;

    private List<Book> books = new ArrayList<>();

    public BookRepository(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Book> findAll() {
        return books;
    }

    public Book findOne(Integer id) {
        return books.stream()
                .filter(book -> book.id().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("404"));
    }

    @PostConstruct
    private void init() {
        books.add(new Book(1, "Reactive Spring", 484, Rating.FIVE_STAR, authorRepository.findByFirstName("Josh")));
        books.add(new Book(2, "Spring Boot Up & Running", 328, Rating.FOUR_STAR, authorRepository.findByFirstName("Mark")));
        books.add(new Book(3, "Heckling with Spring Boot 2.3", 392, Rating.THREE_STAR, authorRepository.findByFirstName("Greg")));
    }
}
