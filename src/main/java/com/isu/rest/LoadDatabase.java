package com.isu.rest;

import com.isu.rest.model.*;
import com.isu.rest.repository.BookRepository;
import com.isu.rest.repository.BookmarkRepository;
import com.isu.rest.repository.PageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.transaction.Transactional;

@Configuration
@Slf4j
public class LoadDatabase {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    PageRepository pageRepository;

    @Autowired
    BookmarkRepository bookmarkRepository;

    @Bean
    CommandLineRunner initDatabase() {
        return args -> {
            Book homeBook = new Book(null, "Home", null, null, null, null);
//            Book homeBook = new Book(null, "Home", null, null, null, null);
            bookRepository.save(homeBook);
            Book SpecialBook = new Book(null, "Home", null, null, null, null);
//            Book SpecialBook = new Book(null, "Home", null, null, null, null);
            bookRepository.save(SpecialBook);

            pageRepository.save(new Page(null, 1, homeBook));
            pageRepository.save(new Page(null, 2, homeBook));

            bookmarkRepository.save(new Bookmark(null, "FirstBookMark", homeBook));
            log.debug("초기화");
        };
    }
}
