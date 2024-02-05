package com.workintech.Javas18Challenge.exceptions;

import com.workintech.Javas18Challenge.dto.AuthorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@Slf4j
@ControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler
    public ResponseEntity<AuthorErrorResponse> authorErrorResponseEntity (AuthorException authorException){

        AuthorErrorResponse authorErrorResponse = new AuthorErrorResponse(authorException.getMessage(),authorException.getHttpStatus().value(), LocalDateTime.now());
        log.error("AuthorException occured!",authorErrorResponse.toString());
        return new ResponseEntity<>(authorErrorResponse,authorException.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity<BookErrorResponse> bookErrorResponseEntity (BookException bookException){

        BookErrorResponse bookErrorResponse = new BookErrorResponse(bookException.getMessage(), bookException.getHttpStatus().value(),LocalDateTime.now());
        log.error("BookException occured!",bookErrorResponse.toString());
        return new ResponseEntity<>(bookErrorResponse,bookException.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity<CategoryErrorResponse> categoryErrorResponseEntity (CategoryException categoryException){
        CategoryErrorResponse categoryErrorResponse = new CategoryErrorResponse(categoryException.getMessage(), categoryException.getHttpStatus().value(),LocalDateTime.now());
        log.error("CategoryException occured!",categoryErrorResponse.toString());
        return new ResponseEntity<>(categoryErrorResponse,categoryException.getHttpStatus());

    }

    @ExceptionHandler
    public ResponseEntity<GlobalErrorResponse> exceptionHandler (Exception exception){
        GlobalErrorResponse globalErrorResponse = new GlobalErrorResponse(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(), LocalDateTime.now());
        log.error("Exception occured!",globalErrorResponse.toString());
        return new ResponseEntity<>(globalErrorResponse, HttpStatusCode.valueOf(globalErrorResponse.getStatus()));
    }



}
