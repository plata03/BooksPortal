package com.example.booksportal.controller;

import com.example.booksportal.dao.DaoBook;
import com.example.booksportal.model.Book;
import com.example.booksportal.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Map;

@RequestMapping("/json")
@RestController
public class Controljson {



    @Autowired
    private DaoBook bookRepository;

    @GetMapping("/allbook")
    public String showJsonBooks() {
        return bookRepository.findAll().toString();
    }

    @GetMapping("/allbook/{title}")
    public String showBookByTitle(@PathVariable String title) {

        return bookRepository.findBookByTitle(title).toString();
    }





}
