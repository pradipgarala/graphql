package com.example.graphql.repository;

import com.example.graphql.model.Author;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AuthorRepository {
    private List<Author> authors = new ArrayList<>();

    public Author findByFirstName(String author) {
        return authors.stream()
                .filter(a -> a.firstName().equals(author))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Author not found"));
    }

    public List<Author> findAll() {
        return authors;
    }

    public Author create(String firstName, String lastName) {
        Author author = new Author(authors.size() + 1, firstName, lastName);
        authors.add(author);

        return author;
    }

    public Author deleteById(Integer id) {
        Author author = authors.stream()
                .filter(a -> a.id().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Author not found"));

        authors.remove(author);

        return author;
    }

    public Author update(Integer id, String firstName, String lastName) {
        Author author = authors.stream()
                .filter(a -> a.id().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Author not found"));

        authors.remove(author);

        Author updatedAuthor = new Author(id, firstName, lastName);
        authors.add(updatedAuthor);

        return updatedAuthor;
    }


    @PostConstruct
    private void init() {
        authors.add(new Author(1, "Josh", "Long"));
        authors.add(new Author(2, "Mark", "Heckler"));
        authors.add(new Author(3, "Greg", "Turnquist"));
    }
}
