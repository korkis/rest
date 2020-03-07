package com.isu.rest;

import com.isu.rest.model.Book;
import com.isu.rest.model.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
@Slf4j
public class BookController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    PageRepository pageRepository;

    @GetMapping("/test")
    public String test() {
        restTemplate.put
        return "";
    }

    @GetMapping
    public List<Book> getAll(@RequestParam(required = false) String title) {
        List<Book> books = new ArrayList<>();
            books = bookRepository.findAll();
            List<Page> pages = pageRepository.findAll();
        if(title == null) {

        } else {
//            Optional<Book> b = bookRepository.findByTitle(title);
//            books.add(b.orElse(null));
//            Book b = bookRepository.findOneByTitle(title);
//            books.add(b);
            List<Book> b = bookRepository.findOneByTitle(title);
            books.addAll(b);
        }
        return books;
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) {
        Book book = bookRepository.findById(id).orElse(null);
        return book;
    }

    @PostMapping()
    public void postBook(@RequestBody Book book) throws Exception {
        if(StringUtils.isEmpty(book.getTitle())) {
            throw new Exception("실패함!");
        }
        bookRepository.save(book);
    }

    @PutMapping("/{id}")
    public void putBook(@PathVariable Long id, @RequestBody Book book) throws Exception {
        book.setId(id);
        bookRepository.save(book);
    }

    @GetMapping("/pages")
    public List<Page> getPages() {
        List<Page> pages = pageRepository.findAll();
        System.out.println(pages.get(0).getBook().getTitle());
        return pages;
    }
}
