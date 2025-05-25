package com.example.practice.config;

import com.example.practice.components.FilterCoffee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoffeeMachine {

    @Bean
    public FilterCoffee coffeeMachine() {
        System.out.println("Coffee machine is ready to brew!");
//        return "Coffee Machine Ready";
        return new FilterCoffee("Espresso", 5, "Espresso");
    }



}
