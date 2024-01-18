package com.example.booksportal.controller;

import com.example.booksportal.dao.DaoBook;
import com.example.booksportal.dao.DaoUser;
import com.example.booksportal.model.Book;
import com.example.booksportal.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class Controllore {

    @Autowired
    private DaoUser userRepository;

    @Autowired
    private DaoBook bookRepository;

    @GetMapping("/")
    public String showForm(User user) { return "welcome"; }

    @GetMapping("/login")
    public String showLoginForm(User user) { return "login"; }

    @GetMapping("/register")
    public String showRegisterForm(User user) {
        return "register";
    }

    @GetMapping("/newbook")
    public String showNewBookForm(Book book, Model model) {

        model.addAttribute("books", bookRepository.findAll());

        return "newbook";
    }

    @GetMapping("/home")
    public String results(Model model, HttpSession session) {
        String username = (String) session.getAttribute("username");

        model.addAttribute("username", username);


        model.addAttribute("books", bookRepository.findAll());
        return "home";
    }



    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String checkPersonInfo(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) {


        User utente = userRepository.login(username, password);

        if(utente == null)
            return "login";
        else {
            session.setAttribute("username", username);
        }
        return "redirect:/home";
    }


    @PostMapping("/register")
    public String registerNewUser(@Valid User user, Model model,  BindingResult bindingResult, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "register";
        }
        //users.add(user);
        userRepository.save(user);
        //model.addAttribute("username", user.getUsername());
        //session.setAttribute("username", user.getUsername());
        return "login";
    }


    @PostMapping("/newbook")
    public String checkBookInfo(@Valid Book book, Model model, BindingResult bindingResult, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "newbook";
        }
        //books.add(book);
        //User user = (User) session.getAttribute("username");


        bookRepository.save(book);


        //bookRepository.save(book);

        //model.addAttribute("books", books);
        return "redirect:/home";
    }

}
