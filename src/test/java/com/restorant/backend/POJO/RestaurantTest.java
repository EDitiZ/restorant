package com.restorant.backend.POJO;

import static org.junit.Assert.*;

public class RestaurantTest {

    private final String NAME = "Versus";
    private final Address address = Address.SKOPJE;
    private final RestaurantType type = RestaurantType.MEDITERRANEAN;
    private final boolean doDelivery = false;
    Restaurant restaurant;
    @org.junit.Before
    public void setUp() {

        restaurant = new Restaurant(NAME,address,type,doDelivery);
        restaurant.addRating(5);
        restaurant.addRating(3);

        restaurant.addPrice(200);
        restaurant.addPrice(400);

    }

    @org.junit.Test
    public void totalRating() {

        assertEquals(4.0,restaurant.getRating(),0.0);
    }

    @org.junit.Test
    public void averagePraceCalculation() {

        assertEquals(300,restaurant.getAveragePrice(),0.0);
    }
}