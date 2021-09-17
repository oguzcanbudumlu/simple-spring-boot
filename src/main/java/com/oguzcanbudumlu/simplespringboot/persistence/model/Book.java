package com.oguzcanbudumlu.simplespringboot.persistence.model;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false)
    private String author;
}
