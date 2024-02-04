package com.workintech.Javas18Challenge.dto;

import com.workintech.Javas18Challenge.entity.Book;

import java.util.List;

public record AuthorResponseWithBooks(Long id, String authorFirstName, String authorLastName, List<Book> bookList) {
}
