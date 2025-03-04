package com.example.argumentresolverplayground.controller;

import com.example.argumentresolverplayground.annotation.Auth;
import com.example.argumentresolverplayground.dto.AuthUser;
import com.example.argumentresolverplayground.filter.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthTestController {

    private final JwtUtil jwtUtil;

    @PostMapping("/auth/signin")
    public String signin() {
        return jwtUtil.createToken(1L);
    }

    @GetMapping("/auth/test")
    public String auth(@Auth AuthUser authUser) {
        String test = "authUser.getId(): " + authUser.getId();
        System.out.println(test);
        return test;
    }
}
