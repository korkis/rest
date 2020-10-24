package com.isu.rest.controller;

import com.isu.rest.repository.BookRepository;
import com.isu.rest.repository.PageRepository;
import com.isu.rest.model.Book;
import com.isu.rest.model.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

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

//    @GetMapping("/test")
//    public ResponseEntity test() {
//
//    }

    @GetMapping
    public List<Book> getAll(@RequestParam(required = false) String title,
                             @RequestParam(required = false) Integer pageNumber) {
        return bookRepository.findByCustom();
//        if(pageNumber != null) {
//            return bookRepository.findByPageNumber(pageNumber);
//        }
//        List<Book> books = bookRepository.findAll();
//        return books;
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) {
        Book book = bookRepository.findById(id).orElse(null);
        return book;
    }

    @PostMapping()
    public Book postBook(String title, String name) throws Exception {
//        if(StringUtils.isEmpty(book.getTitle())) {
//            throw new Exception("실패함");
//        }

        Book b = new Book();
        b.setTitle(title);
        return bookRepository.save(b);
    }

    @PutMapping("/{id}")
    public void putBook(@PathVariable Long id, @RequestBody Book book) throws Exception {
        throw new Exception("POST ERROR");
//        book.setId(id);
//        bookRepository.save(book);
    }

    @GetMapping("/pages")
    public List<Page> getPages() throws Exception {
        throw new Exception("ER");
//        List<Page> pages = pageRepository.findAll();
//        System.out.println(pages.get(0).getBook().getTitle());
//        return pages;
    }
}
