package com.example.practice.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/api/tests")
public class Test {

    @GetMapping("/")
    public String hello(){
        System.out.println("In hello");
        return "Hello";
//        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
