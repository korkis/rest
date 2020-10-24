package com.isu.rest.repository;

import com.isu.rest.model.Book;

import java.util.List;

public interface CustomizedBookRepository {

    public List<Book> findByCustom();

}
