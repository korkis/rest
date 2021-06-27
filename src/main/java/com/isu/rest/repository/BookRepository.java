package com.isu.rest.repository;

import com.isu.rest.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long>, CustomizedBookRepository {

    Optional<Book> findOneById(Long id);

    @Query(value = "select a from Book a left outer join fetch a.bookmarks")
//    @EntityGraph(attributePaths = {"bookmarks"})
    List<Book> findAll();

//    @Query(value = "select a from Book a left join fetch a.pages where a.title = ?1")
//    @Query(value = "select * from Book a inner join Page b on a.id = b.book_id where a.title = ?1", nativeQuery = true)
//    @EntityGraph(attributePaths = {"pages"}, type = EntityGraph.EntityGraphType.LOAD)
    List<Book> findByTitle(String title);

    @Query(value = "select a,b from Book a inner join a.pages b where b.number = ?1")
    List<Book> findByPageNumber(Integer number);

}
