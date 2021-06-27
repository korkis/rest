package com.isu.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.net.URI;

@Controller
public class HomeController {
    @GetMapping
    public String get() {
        return "index";
    }

    @PostMapping("/a")
    public String getA() {
        return "b";
    }

    @GetMapping("/b")
    public String getB() {
        return "b";
    }

}
