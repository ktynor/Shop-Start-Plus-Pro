package com.tynor.shopstartpluspro;

import org.springframework.stereotype.Component;

@Component
public class Product {
    private String name = "";
    private Double price = 0D;
    static final Integer MIN = 50;
    static final Integer MAX = 300;

    public Product() {

    }

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + String.format("%.2f", price) +
                '}';
    }


}
