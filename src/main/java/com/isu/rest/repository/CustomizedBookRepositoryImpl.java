package com.isu.rest.repository;

import com.isu.rest.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class CustomizedBookRepositoryImpl implements CustomizedBookRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Book> findByCustom() {
        return entityManager.createQuery("select b from Book b").getResultList();
    }
}
