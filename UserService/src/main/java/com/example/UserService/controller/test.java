package com.example.UserService.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test {
    @GetMapping(value="/home")
    public String home() {
        return "home authenicated";
    }

    @GetMapping(value="/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String admin() {
        return "admin authenicated";
    }

    @PostMapping(value="/login")
    public void login()
    {
        System.out.println("login");
    }
}
