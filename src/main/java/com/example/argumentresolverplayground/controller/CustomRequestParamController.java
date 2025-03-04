package com.example.argumentresolverplayground.controller;

import com.example.argumentresolverplayground.annotation.CustomRequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomRequestParamController {

    @GetMapping("/custom/request")
    public String customRequest(@CustomRequestParam("name") String name) {
        return "Custom Request Param: " + name;
    }
}
