package com.epam.springsecurity.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping
    public String Greet(HttpServletRequest request){
        return "WELCOME INTO MY IMAGINARY WORLD"+ request.getSession().getId();
    }
}
