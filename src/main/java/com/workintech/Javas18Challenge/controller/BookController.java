package com.workintech.Javas18Challenge.controller;

import com.workintech.Javas18Challenge.converter.DtoConverter;
import com.workintech.Javas18Challenge.dto.BookResponse;
import com.workintech.Javas18Challenge.dto.BookResponseWithAuthorCategory;
import com.workintech.Javas18Challenge.entity.Author;
import com.workintech.Javas18Challenge.entity.Book;
import com.workintech.Javas18Challenge.entity.Category;
import com.workintech.Javas18Challenge.service.AuthorService;
import com.workintech.Javas18Challenge.service.BookService;
import com.workintech.Javas18Challenge.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/workintech")
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;
    private final CategoryService categoryService;

    @Autowired
    public BookController(BookService bookService, AuthorService authorService, CategoryService categoryService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    @GetMapping("/book")
    public List<BookResponseWithAuthorCategory> findAll() {
        return DtoConverter.convertToBookResponseWithAuthorCategoryList(bookService.findAll());
    }

    @GetMapping("/book/{id}")
    public BookResponseWithAuthorCategory findById(@PathVariable long id) {
        Book foundBook = bookService.findById(id);
        return DtoConverter.convertToBookResponseWithAuthorCategory(foundBook);
    }

    @PostMapping("/book/{categoryId}")
    public BookResponse save(@RequestBody Book book, @PathVariable long categoryId) {
        Category foundCategory = categoryService.findById(categoryId);
        book.setCategory(foundCategory);
        foundCategory.addBook(book);
        return DtoConverter.convertToBookResponse(bookService.save(book));
    }



    @PostMapping("/saveByAuthor/{categoryId}/{authorId}")
    public BookResponseWithAuthorCategory saveByAuthor(@RequestBody Book book, @PathVariable long categoryId, @PathVariable long authorId) {
        Author foundAuthor = authorService.findById(authorId);
        Category foundCategory = categoryService.findById(categoryId);


            book.setAuthor(foundAuthor);
            book.setCategory(foundCategory);
            foundAuthor.addBook(book);
            foundCategory.addBook(book);

            return DtoConverter.convertToBookResponseWithAuthorCategory(bookService.save(book));



    }
    @PutMapping("/book/{id}")
    public BookResponse update(@RequestBody Book book,@PathVariable long id){
        Book foundBook = bookService.findById(id);
        foundBook.setName(book.getName());
        return DtoConverter.convertToBookResponse(bookService.save(foundBook));
    }

    @DeleteMapping("/book/{id}")
    public BookResponse delete(@PathVariable long id){
        return DtoConverter.convertToBookResponse(bookService.delete(id));
    }
}