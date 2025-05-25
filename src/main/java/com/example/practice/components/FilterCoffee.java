package com.example.practice.components;

public class FilterCoffee {
    private String name;
    private int price;
    private String typeOfCoffee;

    public FilterCoffee(String name, int price, String typeOfCoffee) {
        this.name = name;
        this.price = price;
        this.typeOfCoffee = typeOfCoffee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTypeOfCoffee() {
        return typeOfCoffee;
    }

    public void setTypeOfCoffee(String typeOfCoffee) {
        this.typeOfCoffee = typeOfCoffee;
    }

    public String getCoffee() {
        return "Coffee Name: " + name + ", Price: " + price + ", Type: " + typeOfCoffee;
    }

}
