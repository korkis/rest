package com.isu.rest.controller;

import com.isu.rest.model.Book;
import com.isu.rest.model.Bookmark;
import com.isu.rest.repository.BookmarkRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookmark")
@Slf4j
public class BookmarkController {

    @Autowired
    BookmarkRepository bookmarkRepository;

    @PutMapping("/{id}")
    public void putBook(@PathVariable Long id, @RequestBody Bookmark newBookmark) throws Exception {
        newBookmark.setId(id);
        bookmarkRepository.save(newBookmark);
    }
}
