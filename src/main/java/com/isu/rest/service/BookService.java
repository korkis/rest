package com.isu.rest.service;

import com.isu.rest.model.Book;
import com.isu.rest.model.Page;
import com.isu.rest.repository.BookRepository;
import com.isu.rest.repository.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Book findById(Long id) {
        Book book = bookRepository.findById(id).orElse(null);
//        System.out.println(book.getPages().get(0).getNumber());
//        System.out.println(book.getPages().get(1).getNumber());
        return book;
    }

    public void testOneBookLazy() {
        System.out.println("Book조회 전");
        Book book = bookRepository.findById(1l).orElse(null);
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
            System.out.println(book.getPages().size());
        }
    }
}
