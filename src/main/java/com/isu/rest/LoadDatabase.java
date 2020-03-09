package com.isu.rest;

import com.isu.rest.model.*;
import com.isu.rest.repository.BookRepository;
import com.isu.rest.repository.PageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    PageRepository pageRepository;

    @Bean
    CommandLineRunner initDatabase() {
        return args -> {
            Book book = new Book(null, "Home", null);
            bookRepository.save(book);
            Book book2 = new Book(null, "Home", null);
            bookRepository.save(book2);

            Page page = new Page(null, 1, book);
            pageRepository.save(page);
            pageRepository.save(new Page(null, 2, book));
        };
    }
}
