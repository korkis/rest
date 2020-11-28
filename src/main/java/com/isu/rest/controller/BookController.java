package com.isu.rest.controller;

import com.isu.rest.repository.BookRepository;
import com.isu.rest.repository.PageRepository;
import com.isu.rest.model.Book;
import com.isu.rest.model.Page;
import com.isu.rest.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    BookService bookService;

//    @GetMapping("/test")
//    public ResponseEntity test() {
//
//    }

    @GetMapping
    public List<Book> getAll(@RequestParam(required = false) String title,
                             @RequestParam(required = false) Integer pageNumber) {
//        return bookRepository.findByCustom();
        return bookRepository.findAll();
//        return bookRepository.findByTitle(title);
//        if(pageNumber != null) {
//            return bookRepository.findByPageNumber(pageNumber);
//        }
//        List<Book> books = bookRepository.findAll();
//        return books;
    }

    @GetMapping("/testOne")
    public boolean testOneBookLazy() {
        bookService.testOneBookLazy();
        return true;
    }

    @GetMapping("/testMultiple")
    public boolean testMultipleLazy() {
        bookService.testMultipleBookLazy();
        return true;
    }

    @GetMapping("/testTran")
    public boolean testTran() {
        try {
            bookService.saveWithTransactional(true);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) {
        Book book = bookService.findById(id);
        book.getPages().forEach((x) -> {
            System.out.println(x.getNumber());
        });
        return book;
    }

    @PostMapping()
    public Book postBook(@RequestBody Book book) throws Exception {
//        if(StringUtils.isEmpty(book.getTitle())) {
//            throw new Exception("실패함");
//        }
        return bookService.save(book);
    }

    @PutMapping("/{id}")
    public void putBook(@PathVariable Long id, @RequestBody Book newBook) throws Exception {
//        book.setId(id);
//        bookRepository.save(book);
//        Book book = bookRepository.findById(id).get();
//        book.setTitle(newBook.getTitle());
//        book.getPages().remove(0);
//        book.getPages().removeAll(book.getPages());
//        newBook.getPages().get(0).setBook(newBook);
//        bookRepository.save(book);
        newBook.setId(id);
        bookService.save(newBook);
    }

    @GetMapping("/pages")
    public List<Page> getPages() throws Exception {
        throw new Exception("ER");
//        List<Page> pages = pageRepository.findAll();
//        System.out.println(pages.get(0).getBook().getTitle());
//        return pages;
    }
}
