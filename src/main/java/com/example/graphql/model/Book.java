package com.example.graphql.model;

import com.example.graphql.model.Rating;

public record Book(Integer id,
                   String title,
                   Integer pages,
                   Rating rating,
                   Author author) {
}
