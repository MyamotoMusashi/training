package com.knifed.bookstore.controllers;

import com.knifed.bookstore.entities.User;
import com.knifed.bookstore.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return this.userRepository.getAllUsers();
    }

    @PostMapping("/register")
    public void getRegister(@RequestBody User user){
       this.userRepository.registerUser(user);
    }
}
