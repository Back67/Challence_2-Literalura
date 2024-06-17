package com.tu_usuario.literatula.controller;

import com.tu_usuario.literatula.model.Book;
import com.tu_usuario.literatula.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/search")
    public List<Book> searchBooks(@RequestParam String language) throws IOException {
        return bookService.searchBooksByLanguage(language);
    }
}
