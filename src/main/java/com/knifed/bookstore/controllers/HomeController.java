package com.knifed.bookstore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String getHome() {
        return "index";
    }

    @GetMapping("/stores")
    public String getStores() {
        return "stores";
    }

    @GetMapping("/authors")
    public String getAuthors(){
        return "authors";
    }

    @GetMapping("/contacts")
    public String getContacts(){
        return "contacts";
    }

    @GetMapping("/login")
    public String getLogin(){
        return "login";
    }
}
