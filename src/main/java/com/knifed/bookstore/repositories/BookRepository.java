package com.knifed.bookstore.repositories;

import com.knifed.bookstore.entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
     Page<Book> findAllByOrderById(PageRequest of);
    //List<Paper> findAllById(Pageable page);
}
