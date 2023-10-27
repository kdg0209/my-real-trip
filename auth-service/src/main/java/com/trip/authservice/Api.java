package com.trip.authservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth/api")
@RestController
public class Api {

    @GetMapping
    public String hello() {
        return "hello";
    }
}
