package com.workintech.Javas18Challenge.service;

import com.workintech.Javas18Challenge.entity.Author;
import com.workintech.Javas18Challenge.exceptions.AuthorException;
import com.workintech.Javas18Challenge.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AuthorServiceImpl implements AuthorService{

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author findById(long id) {
         Optional<Author> foundAuthor = authorRepository.findById(id);
         if(foundAuthor.isPresent()){
             return foundAuthor.get();
         }
         throw new AuthorException("Author with given id is not found:"+id, HttpStatus.NOT_FOUND);


    }

    @Override
    public Author save(Author author) {

        return authorRepository.save(author);
    }

    @Override
    public Author delete(long id) {
        Author willRemove = findById(id);
        authorRepository.deleteById(id);
        return willRemove;
    }
}
