package com.example.javatest.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public String sayHello(String name) {
        if (name == null || name.trim().isEmpty()) {
            return "Hello World!";
        }
        return String.format("Hello %s!", name.trim());
    }
}
