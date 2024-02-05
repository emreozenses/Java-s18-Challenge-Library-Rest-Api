package com.workintech.Javas18Challenge.converter;

import com.workintech.Javas18Challenge.dto.AuthorResponse;
import com.workintech.Javas18Challenge.dto.BookResponse;
import com.workintech.Javas18Challenge.dto.BookResponseWithAuthorCategory;
import com.workintech.Javas18Challenge.dto.CategoryResponse;
import com.workintech.Javas18Challenge.entity.Author;
import com.workintech.Javas18Challenge.entity.Book;
import com.workintech.Javas18Challenge.entity.Category;

import java.util.ArrayList;
import java.util.List;

public class DtoConverter {

    public static AuthorResponse convertToAuthorResponse(Author author){
        return new AuthorResponse(author.getId(), author.getFirstName(), author.getLastName());
    }

    public static List<AuthorResponse> convertToAuthorResponseList (List<Author> authors){
        List<AuthorResponse> authorResponseList = new ArrayList<>();
        authors.forEach(author -> {
            authorResponseList.add(convertToAuthorResponse(author));
        });
        return authorResponseList;
    }

    public static CategoryResponse convertToCategoryResponse(Category category){

        return new CategoryResponse(category.getId(), category.getName(),DtoConverter.convertToBookResponseList(category.getBookList()));
    }

    public static List<CategoryResponse> convertToCategoryResponseList (List<Category> categories){
        List<CategoryResponse> categoryResponseList = new ArrayList<>();
        categories.forEach(category -> {
            categoryResponseList.add(convertToCategoryResponse(category));
        });
        return categoryResponseList;
    }
    public static BookResponseWithAuthorCategory convertToBookResponseWithAuthorCategory (Book book){
        return new BookResponseWithAuthorCategory(book.getId(), book.getName(), book.getAuthor().getFirstName(),book.getAuthor().getLastName(),book.getCategory().getName());
    }

    public static List<BookResponseWithAuthorCategory> convertToBookResponseWithAuthorCategoryList (List<Book> books){
        List<BookResponseWithAuthorCategory> bookResponseWithAuthorCategoryList = new ArrayList<>();
        books.forEach(book -> {
            bookResponseWithAuthorCategoryList.add(convertToBookResponseWithAuthorCategory(book));
        });
        return bookResponseWithAuthorCategoryList;
    }

    public static BookResponse convertToBookResponse (Book book){
        return new BookResponse(book.getId(), book.getName());
    }
    public static List<BookResponse> convertToBookResponseList (List<Book> books){
        List<BookResponse> bookResponseList = new ArrayList<>();
        if(books == null){
            return null;
        }

        else {
            books.forEach(book -> {
                bookResponseList.add(convertToBookResponse(book));
            });
        }
        return bookResponseList;
    }







}
