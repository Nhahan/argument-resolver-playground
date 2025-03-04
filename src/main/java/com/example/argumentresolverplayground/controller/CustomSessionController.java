package com.example.argumentresolverplayground.controller;

import com.example.argumentresolverplayground.annotation.CustomSessionAttribute;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomSessionController {

    @PostMapping("/session")
    public void setSession(HttpSession session) {
        session.setAttribute("hello", "world!");
    }

    @GetMapping("/session")
    public String getSession(
            @CustomSessionAttribute("hello") String sessionValue
    ) {
        return "hello=" + sessionValue;
    }
}
