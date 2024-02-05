package com.workintech.Javas18Challenge.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class AuthorException extends RuntimeException{

    private HttpStatus httpStatus;
    public AuthorException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }


}
