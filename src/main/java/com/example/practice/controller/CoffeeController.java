package com.example.practice.controller;

import com.example.practice.services.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoffeeController {

    @Autowired
    private CoffeeService coffeeService;

    @GetMapping("/api/coffee/{type}")
    public String getCoffee(@PathVariable String type) {
        // Call the service to get the coffee details based on the type
        return coffeeService.getCoffeeByType(type);
    }
}
