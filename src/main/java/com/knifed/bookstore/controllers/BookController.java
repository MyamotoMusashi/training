package com.knifed.bookstore.controllers;

import com.knifed.bookstore.entities.Book;
import com.knifed.bookstore.repositories.BookRepository;
import com.knifed.bookstore.services.BookService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/api/books")
    public List<Book> getBooks(@RequestParam String page){
        Integer pageNumber = Integer.parseInt(page);
        return this.bookService.findAllByPageNumber(pageNumber);
    }

    @GetMapping("/api/books/{id}")
    public Book getBookById(@PathVariable String id) {
        return this.bookService.findBookById(id);
    }

    @PostMapping("/api/books")
    public void addBook(@RequestBody Book book){
        this.bookService.addBook(book);
    }

    @PutMapping("/api/books")
    public void updateBook(@RequestBody Book book) {
        this.bookService.updateBook(book);
    }
    
    @DeleteMapping("/api/books")
    public void deleteBook(@RequestBody Book book){
        this.bookService.deleteBook(book);
    }
}
