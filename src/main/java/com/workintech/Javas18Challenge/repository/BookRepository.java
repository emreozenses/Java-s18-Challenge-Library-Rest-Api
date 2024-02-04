package com.workintech.Javas18Challenge.repository;

import com.workintech.Javas18Challenge.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
