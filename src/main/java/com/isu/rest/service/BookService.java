package com.isu.rest.service;

import com.isu.rest.model.Book;
import com.isu.rest.model.Page;
import com.isu.rest.repository.BookRepository;
import com.isu.rest.repository.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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
}
