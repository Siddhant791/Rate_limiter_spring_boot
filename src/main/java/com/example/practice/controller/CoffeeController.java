package com.example.practice.controller;

import com.example.practice.components.RequestScope;
import com.example.practice.services.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CoffeeController {

    @Autowired
    private CoffeeService coffeeService;

    @Autowired
    private RequestScope requestScope; // Inject the RequestScope component

    @Autowired
    private RestTemplate restTemplate; // Inject RestTemplate for REST calls

    @GetMapping("/api/coffee/{type}")
    public String getCoffee(@PathVariable String type) {
        // Call the service to get the coffee details based on the type
        return coffeeService.getCoffeeByType(type);
    }

    @GetMapping("/api/id")
    public String getRequestId() {
        // Return the request ID from the RequestScope component
        return "Request ID: " + requestScope.getRequestId();
    }

    @GetMapping("/api/restcall")
    public ResponseEntity<String> restCall(){
        return restTemplate.exchange(
                "http://localhost:8081/api/test/",
                HttpMethod.GET,
                null,
                String.class
        );
    }

}
