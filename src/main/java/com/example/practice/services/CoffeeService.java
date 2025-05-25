package com.example.practice.services;

import com.example.practice.components.FilterCoffee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoffeeService {

    @Autowired
    private FilterCoffee filterCoffee;

    public String getFilterCoffee(){
        return filterCoffee.getCoffee();
    }
}
