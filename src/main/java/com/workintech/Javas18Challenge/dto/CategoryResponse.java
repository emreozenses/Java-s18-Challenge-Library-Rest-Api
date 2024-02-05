package com.workintech.Javas18Challenge.dto;

import com.workintech.Javas18Challenge.entity.Book;

import java.util.List;

public record CategoryResponse(Long id, String categoryName, List<BookResponse> bookResponseList) {
}
