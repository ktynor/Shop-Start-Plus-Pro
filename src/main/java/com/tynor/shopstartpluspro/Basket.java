package com.tynor.shopstartpluspro;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Basket {

    List<Product> productList = new ArrayList<>();
    private double totalPrice;

    public Basket() {
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Double getTotalPrice() {
        setTotalPrice(productList);
        return totalPrice;
    }

    public void setTotalPrice(List<Product> productList) {
        this.totalPrice = productList.stream().map(Product::getPrice).mapToDouble(Product -> Product).sum();
    }

    @Override
    public String toString() {
        return "Basket{" +
                "productList=" + productList +
                ", totalPrice=" + String.format("%.2f", totalPrice) + '}';
    }
}
