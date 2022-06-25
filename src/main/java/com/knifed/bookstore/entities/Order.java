package com.knifed.bookstore.entities;

public class Order {
    public static Integer counter = 0;
    private Integer id;
    private Book book;
    private User user;
    private OrderStatus status;

    public Order(Book book, User user){
        this.setBook(book);
        this.setUser(user);
        this.setStatus(OrderStatus.NotProcessed);
        this.id = Order.receiveId();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public static Integer receiveId(){
        Order.counter++;
        return Order.counter;
    }

    public Integer getId() {
        return id;
    }
}
