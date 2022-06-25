package com.knifed.bookstore.entities;

import javax.persistence.*;

@Entity()
@Table(name = "book")
public class Book {

    @Column(name = "book_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String title;

    @Column
    private Integer quantity;

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
