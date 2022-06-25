package com.knifed.bookstore.controllers;

import com.knifed.bookstore.entities.Book;
import com.knifed.bookstore.entities.Order;
import com.knifed.bookstore.repositories.BookRepository;
import com.knifed.bookstore.repositories.ShoppingCartRepository;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Optional;

@RestController
public class ShoppingCartController {

    private final ShoppingCartRepository shoppingCartRepository;
    private final BookRepository bookRepository;

    public ShoppingCartController(ShoppingCartRepository shoppingCartRepository, BookRepository bookRepository){
        this.shoppingCartRepository = shoppingCartRepository;
        this.bookRepository = bookRepository;
    }

    @GetMapping("/shopping-cart")
    public HashMap<String, Order> getShoppingCartOrders(){
        return this.shoppingCartRepository.getShoppingCartOrders();
    }

    @PostMapping("/shopping-cart")
    public void addToShoppingCart(@RequestBody Order order){
        order.getBook().setQuantity(1);
        this.shoppingCartRepository.addToShoppingCard(order);
    }

    @PutMapping("/shopping-cart")
    public void clearShoppingCart(
            @RequestParam(required = false, name="clear") Optional<String> query,
            @RequestParam(required = false, name="remove") Optional<String> remove)
    {
        if (query.isPresent()) {
            this.shoppingCartRepository.clearShoppingCart();
        }

        if (remove.isPresent() && !remove.get().isEmpty()){
            Book book = this.bookRepository.findAll()
                    .stream()
                    .filter(b -> b.getId() == Integer.parseInt(remove.get()))
                    .findFirst()
                    .orElse(null);

            Book bookToBeReturned = this.shoppingCartRepository.getShoppingCart().getOrders().get(remove.get()).getBook();

            this.shoppingCartRepository.removeOrderById(Integer.parseInt(remove.get()));

            if (book != null){
                book.setQuantity(book.getQuantity() + bookToBeReturned.getQuantity());
            }
            else {
                this.bookRepository.save(bookToBeReturned);
            }
        }
    }
}