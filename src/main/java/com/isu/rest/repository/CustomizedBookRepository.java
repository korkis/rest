package com.isu.rest.repository;

import com.isu.rest.model.Book;

import java.util.List;

interface CustomizedBookRepository {
    List<Book> findBooks();
}
