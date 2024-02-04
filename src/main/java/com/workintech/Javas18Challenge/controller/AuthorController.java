package com.workintech.Javas18Challenge.controller;

import com.workintech.Javas18Challenge.entity.Author;
import com.workintech.Javas18Challenge.entity.Book;
import com.workintech.Javas18Challenge.service.AuthorService;
import com.workintech.Javas18Challenge.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workintech")
public class AuthorController {

    private AuthorService authorService;
    private BookService bookService;

    @Autowired
    public AuthorController(AuthorService authorService,BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @GetMapping("/author")
    public List<Author> findAll(){
        return authorService.findAll();
    }

    @GetMapping("/author/{id}")
    public Author findById(@PathVariable long id){
        return authorService.findById(id);
    }
    @PostMapping("/author")
    public Author save(@RequestBody Author author){
        return authorService.save(author);
    }

    @PostMapping("/author/{bookId}")
    public Author saveByBookId(@RequestBody Author author,@PathVariable long bookId){
        Book foundBook = bookService.findById(bookId);
        author.addBook(foundBook);
        return authorService.save(author);
    }

    @PutMapping("/author/{authorId}")
    public Author update(@RequestBody Author author,@PathVariable long authorId){
        Author updatedAuthor = authorService.findById(authorId);
        updatedAuthor.setFirstName(author.getFirstName());
        updatedAuthor.setLastName(author.getLastName());
        return authorService.save(updatedAuthor);
    }

    @DeleteMapping("/author/{id}")
    public Author delete(@PathVariable long id){
        return authorService.delete(id);
    }


}
