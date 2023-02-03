package com.restorant.backend.POJO;

import static org.junit.Assert.*;

public class RestaurantTest {

    private final String NAME = "Versus";
    private final Address ADDRESS = Address.SKOPJE;
    private final RestaurantType TYPE = RestaurantType.MEDITERRANEAN;
    private final boolean DODELIVERY = false;
    private final double LATITUDE = 42.513;
    private final double ALTITUDE = 21.13;
    Restaurant restaurant;
    @org.junit.Before
    public void setUp() {

        restaurant = new Restaurant(NAME,ADDRESS,TYPE,DODELIVERY,LATITUDE,ALTITUDE);
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