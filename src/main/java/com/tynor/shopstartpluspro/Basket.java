package com.tynor.shopstartpluspro;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Basket {

    List<Product> productList = new ArrayList<>();
    private double totalPrice;

    @Value("${vatTax}")
    private Integer vatTax;

    @Value("${discount}")
    private Integer discount;

    public Basket() {
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public double getTotalPrice() {
        setTotalPrice(productList);
        return totalPrice;
    }

    public double getTotalPriceWithVAT() {
        setTotalPrice(productList);
        return totalPrice * (100 + vatTax) / 100;
    }

    public double getTotalPriceWithVatAndDiscount() {
        return getTotalPriceWithVAT() * (1 - (double) discount / 100);
    }

    public void setTotalPrice(List<Product> productList) {
        this.totalPrice = productList.stream().map(Product::getPrice).mapToDouble(Product -> Product).sum();
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getVatTax() {
        return vatTax;
    }

    public void setVatTax(Integer vatTax) {
        this.vatTax = vatTax;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "productList=" + productList +
                ", totalPrice=" + String.format("%.2f", totalPrice) + '}';
    }
}
