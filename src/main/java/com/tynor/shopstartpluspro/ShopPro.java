package com.tynor.shopstartpluspro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Profile("Pro")
public class ShopPro {
    @Autowired
    Basket basket;

    @EventListener(ApplicationContextEvent.class)
    public void get() {

        System.out.println("Basket total price with VAT and discount: PLN " + String.format("%.2f", basket.getTotalPriceWithVatAndDiscount()));

    }
}
