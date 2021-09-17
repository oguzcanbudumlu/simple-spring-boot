package com.oguzcanbudumlu.simplespringboot.controller;


import com.oguzcanbudumlu.simplespringboot.errorhandling.exceptions.BookIdMismatchException;
import com.oguzcanbudumlu.simplespringboot.persistence.model.Book;
import com.oguzcanbudumlu.simplespringboot.persistence.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public Iterable findAll() {
        return bookRepository.findAll();
    }

    @GetMapping("/title/{bookTitle}")
    public List findByTitle(@PathVariable String bookTitle) {
        return bookRepository.findByTitle(bookTitle);
    }

    @GetMapping("/{id}")
    public Book findOne(@PathVariable Long id) {
        return bookRepository.findById(id)
                .orElseThrow();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookRepository.findById(id)
                .orElseThrow();
        bookRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable Long id) {
        if(book.getId() != id) {
            throw new BookIdMismatchException();
        }

        bookRepository.findById(id)
                .orElseThrow();

        return bookRepository.save(book);
    }
}
