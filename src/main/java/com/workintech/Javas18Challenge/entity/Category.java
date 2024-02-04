package com.workintech.Javas18Challenge.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category",schema = "fsweb")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @JsonIgnore
    @OneToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,
             CascadeType.PERSIST,CascadeType.REFRESH},mappedBy = "category")
    private List<Book> bookList;

    public void addBook(Book book){
        if(bookList == null){
            bookList = new ArrayList<>();
        }
        bookList.add(book);
    }

}
