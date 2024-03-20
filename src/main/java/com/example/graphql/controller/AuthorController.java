package com.example.graphql.controller;

import com.example.graphql.model.Author;
import com.example.graphql.repository.AuthorRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @QueryMapping
    public List<Author> allAuthors() {
        return authorRepository.findAll();
    }

    @MutationMapping
    public Author createAuthor(@Argument String firstName,
                               @Argument String lastName) {
        return authorRepository.create(firstName, lastName);
    }

    @MutationMapping
    public Author updateAuthor(@Argument Integer id,
                               @Argument String firstName,
                               @Argument String lastName) {
        return authorRepository.update(id, firstName, lastName);
    }

    @MutationMapping
    public Author deleteAuthor(@Argument Integer id) {
        return authorRepository.deleteById(id);
    }

}
