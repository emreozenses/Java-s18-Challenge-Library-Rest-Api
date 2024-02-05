package com.workintech.Javas18Challenge.controller;

import com.workintech.Javas18Challenge.converter.DtoConverter;
import com.workintech.Javas18Challenge.dto.AuthorResponse;
import com.workintech.Javas18Challenge.entity.Author;
import com.workintech.Javas18Challenge.entity.Book;
import com.workintech.Javas18Challenge.service.AuthorService;
import com.workintech.Javas18Challenge.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
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
    public List<AuthorResponse> findAll(){
        return DtoConverter.convertToAuthorResponseList(authorService.findAll());
    }

    @GetMapping("/author/{id}")
    public AuthorResponse findById(@PathVariable long id){
        return DtoConverter.convertToAuthorResponse(authorService.findById(id));
    }
    @PostMapping("/author")
    public AuthorResponse save(@RequestBody Author author){
        return DtoConverter.convertToAuthorResponse(authorService.save(author));
    }

    @PostMapping("/author/{bookId}")
    public AuthorResponse saveByBookId(@RequestBody Author author,@PathVariable long bookId){
        Book foundBook = bookService.findById(bookId);
        author.addBook(foundBook);
        return DtoConverter.convertToAuthorResponse(authorService.save(author));
    }

    @PutMapping("/author/{authorId}")
    public AuthorResponse update(@RequestBody Author author,@PathVariable long authorId){
        Author updatedAuthor = authorService.findById(authorId);
        updatedAuthor.setFirstName(author.getFirstName());
        updatedAuthor.setLastName(author.getLastName());
        return DtoConverter.convertToAuthorResponse(authorService.save(updatedAuthor));
    }
    @PutMapping("/author/{authorId}/{bookId}")
    public AuthorResponse update(@RequestBody Author author,@PathVariable long authorId,@PathVariable long bookId){
        Author updatedAuthor = authorService.findById(authorId);
        updatedAuthor.setFirstName(author.getFirstName());
        updatedAuthor.setLastName(author.getLastName());
        bookService.findById(bookId).setAuthor(updatedAuthor);
        updatedAuthor.addBook(bookService.findById(bookId));
        return DtoConverter.convertToAuthorResponse(authorService.save(updatedAuthor));
    }

    @DeleteMapping("/author/{id}")
    public AuthorResponse delete(@PathVariable long id){
        return DtoConverter.convertToAuthorResponse(authorService.delete(id));
    }


}
