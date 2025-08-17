package com.example.practice.components;

public interface Test {

    default void test(){
        System.out.println("from interface");
    }
}