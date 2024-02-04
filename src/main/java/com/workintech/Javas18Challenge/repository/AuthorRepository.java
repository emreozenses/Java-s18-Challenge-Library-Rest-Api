package com.workintech.Javas18Challenge.repository;

import com.workintech.Javas18Challenge.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
