package com.oguzcanbudumlu.simplespringboot.persistence.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import org.apache.commons.lang3.RandomStringUtils;

@Entity
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false)
    private String author;


    public static Book randomGenerate() {
        Book book = new Book();
        book.setTitle(RandomStringUtils.randomAlphabetic(10));
        book.setAuthor(RandomStringUtils.randomAlphabetic(15));
        return book;
    }
}
