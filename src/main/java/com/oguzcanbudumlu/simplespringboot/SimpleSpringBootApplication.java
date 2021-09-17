package com.oguzcanbudumlu.simplespringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.oguzcanbudumlu.simplespringboot.persistence.repo")
@EntityScan("com.oguzcanbudumlu.simplespringboot.persistence.model")
@SpringBootApplication
public class SimpleSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleSpringBootApplication.class, args);
    }

}
