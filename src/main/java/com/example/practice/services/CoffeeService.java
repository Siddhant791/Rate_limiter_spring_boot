package com.example.practice.services;

import com.example.practice.components.CoffeeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CoffeeService {

    @Autowired
    private Map<String, CoffeeType> coffeeTypeMap; // Inject all CoffeeType beans into a Map

    public String getCoffeeByType(String coffeeType) {
        CoffeeType coffee = coffeeTypeMap.get(coffeeType); // Retrieve the bean by name
        if (coffee != null) {
            return coffee.getCoffee();
        }
        return "Coffee type not found!";
    }
}
