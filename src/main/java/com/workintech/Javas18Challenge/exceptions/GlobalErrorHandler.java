package com.workintech.Javas18Challenge.exceptions;

import com.workintech.Javas18Challenge.dto.AuthorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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



    //Bu Exception Handler (MethodArgumentNotValidException) bize Validation hatası olduğunda
    // hatanın içinden bizim uyarı için yazdığımız mesajları ekrana bastırmamızı sağlar.
    @ExceptionHandler
    public ResponseEntity handleException(MethodArgumentNotValidException exception){
        List errorList = exception.getBindingResult().getFieldErrors().stream()
                .map(fieldError ->{
                    Map<String,String> errorMap = new HashMap<>();
                    errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
                    return errorMap;
                }).collect(Collectors.toList());
        log.error("MethodArgumentNotValidException occured!",exception.getMessage());
        return new ResponseEntity(errorList, HttpStatus.BAD_REQUEST);
    }



}
