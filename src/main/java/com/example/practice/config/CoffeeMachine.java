package com.example.practice.config;

import com.example.practice.components.CoffeeType;
import com.example.practice.components.TestBean;
import com.example.practice.components.FilterCoffee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class CoffeeMachine {

//    @Primary
    @Bean(name = "filtercoffee") // Bean name matches the path variable value
    public CoffeeType coffeeMachine() {
        System.out.println("Filter coffee machine is ready to brew!");
        return new FilterCoffee("Espresso", 5, "Espresso");
    }

    @Primary
    @Bean(name = "cappicino") // Bean name matches the path variable value
    public CoffeeType testMachine() {
        System.out.println("Test coffee machine is ready to brew!");
        return new TestBean("cappicino", 6, "cappicino");
    }

    @Bean(name = "latte") // Bean name matches the path variable value
    public CoffeeType Latte() {
        System.out.println("Test coffee machine is ready to brew!");
        return new TestBean("Latte", 4, "latte");
    }

}
