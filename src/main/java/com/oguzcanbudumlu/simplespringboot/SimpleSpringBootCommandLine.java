package com.oguzcanbudumlu.simplespringboot;

import com.oguzcanbudumlu.simplespringboot.persistence.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import io.restassured.RestAssured;

@Component
public class SimpleSpringBootCommandLine implements CommandLineRunner {
    private static Logger LOG = LoggerFactory.getLogger(SimpleSpringBootCommandLine.class);
    private static final String API_ROOT
            = "http://localhost:8081/api/books";

    @Override
    public void run(String... args) throws Exception {
        LOG.error("test from command line");

        Book book = Book.randomGenerate();
        LOG.error(book.getTitle());
        LOG.error(book.getAuthor());

        RestAssured
                .given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(book)
                .post(API_ROOT);


    }
}
