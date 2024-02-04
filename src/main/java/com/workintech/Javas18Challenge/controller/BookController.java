package com.workintech.Javas18Challenge.controller;

import com.workintech.Javas18Challenge.entity.Author;
import com.workintech.Javas18Challenge.entity.Book;
import com.workintech.Javas18Challenge.entity.Category;
import com.workintech.Javas18Challenge.service.AuthorService;
import com.workintech.Javas18Challenge.service.BookService;
import com.workintech.Javas18Challenge.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/book/{id}")
    public Book findById(@PathVariable long id) {
        return bookService.findById(id);
    }

    @PostMapping("/book/{categoryId}")
    public Book save(@RequestBody Book book, @PathVariable long categoryId) {
        Category foundCategory = categoryService.findById(categoryId);
        book.setCategory(foundCategory);
        foundCategory.addBook(book);
        return bookService.save(book);
    }



    @PostMapping("/saveByAuthor/{categoryId}/{authorId}")
    public Book saveByAuthor(@RequestBody Book book, @PathVariable long categoryId, @PathVariable long authorId) {
        Author foundAuthor = authorService.findById(authorId);
        Category foundCategory = categoryService.findById(categoryId);


            book.setAuthor(foundAuthor);
            book.setCategory(foundCategory);
            foundAuthor.addBook(book);
            foundCategory.addBook(book);

            return bookService.save(book);



    }
    @PutMapping("/book/{id}")
    public Book update(@RequestBody Book book,@PathVariable long id){
        Book foundBook = bookService.findById(id);
        foundBook.setName(book.getName());
        return bookService.save(foundBook);
    }

    @DeleteMapping("/book/{id}")
    public Book delete(@PathVariable long id){
        return bookService.delete(id);
    }
}