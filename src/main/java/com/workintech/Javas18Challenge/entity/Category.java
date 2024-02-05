package com.workintech.Javas18Challenge.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @Size(min = 3,max = 45,message = "İsim, 45 karaakterden büyük,3 karakterden küçük olamaz!")
    @NotNull
    private String name;


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
