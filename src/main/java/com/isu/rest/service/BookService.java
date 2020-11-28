package com.isu.rest.service;

import com.isu.rest.model.Book;
import com.isu.rest.model.Page;
import com.isu.rest.repository.BookRepository;
import com.isu.rest.repository.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    PageRepository pageRepository;

    public Book save(Book book) {
        Book savedBook = bookRepository.save(book);
        book.setTitle("Hello Book");
        Page p = new Page();
        p.setNumber(5);
        p.setBook(savedBook);
//        pageRepository.save(p);
        return savedBook;
    }

    public Book saveBookById(Long id) {
        Book book = bookRepository.findById(id).get();
        book.setTitle("New ID");
        Page p = new Page();
        p.setNumber(5);
        pageRepository.save(p);
        return book;
    }

    @Transactional
    public Book findById(Long id) {
        Book book = bookRepository.findById(id).orElse(null);
//        System.out.println(book.getPages().get(0).getNumber());
//        System.out.println(book.getPages().get(1).getNumber());
        return book;
    }

    public void testOneBookLazy() {
        System.out.println("Book조회 전");
        Book book = bookRepository.findById(1l).orElse(null);
//        Book book = bookRepository.findByTitle("Home");
//        org.springframework.data.domain.Page<Book> books = bookRepository.findByTitle("Home", PageRequest.of(0, 1));
//        Book book = books.getContent().get(0);
//        Book book = bookRepository.findByTitle("Home", PageRequest.of(0, 1);
        System.out.println("Book조회 완료");
        System.out.println("Title조회 전");
        System.out.println("bookTitle:" + book.getTitle());
        System.out.println("Title조회 완료");
        System.out.println("Page조회 전");
        System.out.println("Page Size:" + book.getPages().size());
        System.out.println("Page조회 완료");
        System.out.println("Page 루프 시작");
        for(Page p : book.getPages()) {
            System.out.println("Page " + p.getNumber());
        }
        System.out.println("Page 루프 끝");
    }

    public void testMultipleBookLazy() {
        List<Book> books = bookRepository.findByTitle("Home");
        for(Book book : books) {
            for(Page page : book.getPages()) {
                System.out.println("book:" + book.getId() + ", page:" + page.getId());
            }
            System.out.println("Loop 하나 종료");
        }
    }

    @Transactional
    public void saveWithTransactional(Boolean exception) {
        try {
            Book book = new Book();
            book.setTitle("Book1");
            bookRepository.save(book);
            if (exception) {
                throw new RuntimeException("HI");
            }
            Book book2 = new Book();
            book2.setTitle("Book2");
            bookRepository.save(book2);
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
