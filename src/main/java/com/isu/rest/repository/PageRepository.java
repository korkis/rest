package com.isu.rest.repository;

import com.isu.rest.model.Book;
import com.isu.rest.model.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PageRepository extends JpaRepository<Page, Long> {

}
