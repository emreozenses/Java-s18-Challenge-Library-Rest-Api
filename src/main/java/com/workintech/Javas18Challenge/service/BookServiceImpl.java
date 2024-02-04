package com.workintech.Javas18Challenge.service;

import com.workintech.Javas18Challenge.entity.Book;
import com.workintech.Javas18Challenge.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            return optionalBook.get();
        }
            throw new RuntimeException("Given book id not exist:"+id);

    }
    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book delete(long id) {
        Book willRemove = findById(id);
        bookRepository.deleteById(id);
        return willRemove;

    }




}
