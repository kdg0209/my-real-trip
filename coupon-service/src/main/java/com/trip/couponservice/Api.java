package com.trip.couponservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class Api {

    @GetMapping
    public String hello() {
        return "coupon-service hello";
    }
}

