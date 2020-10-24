package com.isu.rest.repository;

import com.isu.rest.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long>, CustomizedBookRepository {

    Optional<Book> findOneById(Long id);

    List<Book> findOneByTitle(String title);

    @Query(value = "select a,b from Book a inner join a.pages b where b.number = ?1")
    List<Book> findByPageNumber(Integer number);

}
