package com.isu.rest;

import com.isu.rest.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findOneById(Long id);

    List<Book> findOneByTitle(String title);

}
