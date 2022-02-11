package com.tynor.shopstartpluspro;

import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final Basket basket;

    public ProductService(Basket basket) {
        this.basket = basket;
        Product product1 = new Product("p1", getRandomPrice());
        Product product2 = new Product("p2", getRandomPrice());
        Product product3 = new Product("p3", getRandomPrice());
        Product product4 = new Product("p4", getRandomPrice());
        Product product5 = new Product("p5", getRandomPrice());
        addToBasket(product1);
        addToBasket(product2);
        addToBasket(product3);
        addToBasket(product4);
        addToBasket(product5);
    }

    private double getRandomPrice() {
        return (Math.random() * (Product.MAX - Product.MIN)) + Product.MIN;
    }

    public void addToBasket(Product product) {
        basket.getProductList().add(product);
    }

    @EventListener(ApplicationContextEvent.class)
    public void get() {


        System.out.println("Basket product list: " + basket.getProductList());
        System.out.println("Basket total price: PLN " + String.format("%.2f", basket.getTotalPrice()));
    }

}
