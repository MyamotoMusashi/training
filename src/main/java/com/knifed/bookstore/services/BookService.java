package com.knifed.bookstore.services;

import com.knifed.bookstore.entities.Book;
import com.knifed.bookstore.repositories.BookRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book) {
        this.bookRepository.save(book);
    }

    public void updateBook(Book book){
        this.bookRepository.save(book);
    }

    public void deleteBook(Book book){
        this.bookRepository.delete(book);
    }

    public List<Book> findAllByPageNumber(Integer pageNumber) {
        Integer pageSize = 6;
        return this.bookRepository.findAll(PageRequest.of(pageNumber, pageSize).withSort(Sort.by("id"))).getContent();
    }

    public Book findBookById(String id){
        Integer idInteger = Integer.parseInt(id);
        return this.bookRepository.findById(idInteger).get();
    }
}
