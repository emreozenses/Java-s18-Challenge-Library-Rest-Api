package com.workintech.Javas18Challenge.service;

import com.workintech.Javas18Challenge.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> findAll();

    Book findById(long id);

    Book save(Book book);

    Book delete(long id);



}
