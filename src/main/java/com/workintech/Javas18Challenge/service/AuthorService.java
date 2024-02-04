package com.workintech.Javas18Challenge.service;

import com.workintech.Javas18Challenge.entity.Author;

import java.util.List;

public interface AuthorService {

    List<Author> findAll();

    Author findById(long id);

    Author save(Author author);

    Author delete(long id);



}
