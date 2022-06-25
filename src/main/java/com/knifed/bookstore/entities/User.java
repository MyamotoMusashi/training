package com.knifed.bookstore.entities;

public class User {

    private String name;
    private ShoppingCart shoppingCart;
    private UserRole userRole;

    public User(String name, ShoppingCart shoppingCart, UserRole userRole){
        this.setName(name);
        this.setShoppingCart(shoppingCart);
        this.setUserRole(userRole);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
}
