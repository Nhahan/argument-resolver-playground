package com.example.argumentresolverplayground.controller;

import com.example.argumentresolverplayground.annotation.CustomPathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomPathVariableController {

    @GetMapping("/custom/path/{name}")
    public String customPath(@CustomPathVariable("name") String name) {
        return "Custom Path Variable: " + name;
    }
}
