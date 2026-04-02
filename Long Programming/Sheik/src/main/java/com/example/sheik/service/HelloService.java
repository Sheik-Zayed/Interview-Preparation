package com.example.sheik.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String message() {
        return "Hello Lejju! From Service Layer";
    }

}