package com.isu.rest.repository;

import com.isu.rest.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class CustomizedBookRepositoryImpl implements CustomizedBookRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Book> findBooks() {
        return em.createNativeQuery("select * from book", Book.class).getResultList();
    }
}
