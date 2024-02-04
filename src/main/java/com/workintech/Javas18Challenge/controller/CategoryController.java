package com.workintech.Javas18Challenge.controller;

import com.workintech.Javas18Challenge.entity.Category;
import com.workintech.Javas18Challenge.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workintech")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/category")
    public List<Category> findAll(){
        return categoryService.findAll();
    }

    @GetMapping("/category/{id}")
    public Category findById(@PathVariable long id){
        return categoryService.findById(id);
    }

    @PostMapping("/category")
    public Category save(@RequestBody Category category){
        return categoryService.save(category);
    }

    @PutMapping("/category/{id}")
    public Category update(@RequestBody Category category,@PathVariable long id){
        Category willUpdate =  categoryService.findById(id);
        willUpdate.setName(category.getName());
        return categoryService.save(willUpdate);
    }

    @DeleteMapping("/category/{id}")
    public Category delete(@PathVariable long id){
        return categoryService.delete(id);
    }




}
