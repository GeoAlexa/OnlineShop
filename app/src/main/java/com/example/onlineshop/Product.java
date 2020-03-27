package com.example.onlineshop;

public class Product {

    private String name;
    private String description;

    public  Product(String productName, String productDescription) {
        name = productName;
        description = productDescription;
    }

    public String getName()
    {
        return this.name;
    }

    public String getDescription()
    {
        return this.description;
    }

}
