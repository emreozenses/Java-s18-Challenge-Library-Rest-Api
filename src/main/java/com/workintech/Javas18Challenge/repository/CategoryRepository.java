package com.workintech.Javas18Challenge.repository;

import com.workintech.Javas18Challenge.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
