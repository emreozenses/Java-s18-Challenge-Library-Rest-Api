package com.workintech.Javas18Challenge.controller;

import com.workintech.Javas18Challenge.converter.DtoConverter;
import com.workintech.Javas18Challenge.dto.CategoryResponse;
import com.workintech.Javas18Challenge.entity.Category;
import com.workintech.Javas18Challenge.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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
    public List<CategoryResponse> findAll(){
        return DtoConverter.convertToCategoryResponseList(categoryService.findAll());
    }

    @GetMapping("/category/{id}")
    public CategoryResponse findById(@PathVariable long id){
        return DtoConverter.convertToCategoryResponse(categoryService.findById(id));
    }

    @PostMapping("/category")
    public CategoryResponse save(@Validated @RequestBody Category category){

        return DtoConverter.convertToCategoryResponse(categoryService.save(category));
    }

    @PutMapping("/category/{id}")
    public CategoryResponse update(@Validated @RequestBody Category category,@PathVariable long id){
        Category willUpdate =  categoryService.findById(id);
        willUpdate.setName(category.getName());
        return DtoConverter.convertToCategoryResponse(categoryService.save(willUpdate));
    }

    @DeleteMapping("/category/{id}")
    public CategoryResponse delete(@PathVariable long id){

        return DtoConverter.convertToCategoryResponse(categoryService.delete(id));
    }




}
