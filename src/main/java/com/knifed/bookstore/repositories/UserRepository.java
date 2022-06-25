package com.knifed.bookstore.repositories;

import com.knifed.bookstore.entities.Order;
import com.knifed.bookstore.entities.ShoppingCart;
import com.knifed.bookstore.entities.User;
import com.knifed.bookstore.entities.UserRole;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class UserRepository {
    private List<User> userList;

    public UserRepository(List<User> userList){
        this.userList = userList;
    }

    public void registerUser(User user){
        User newUser = new User(user.getName(), new ShoppingCart(new HashMap<String, Order>()), UserRole.User);
        this.userList.add(newUser);
    }

    public List<User> getAllUsers(){
        return this.userList;
    }
}
