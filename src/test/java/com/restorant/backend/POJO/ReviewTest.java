package com.restorant.backend.POJO;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReviewTest {

    Review review;
    @Before
    public void setUp() {
        User user = new User("Endrit","Ziba",Address.STRUGA,"070208639");
        Restaurant restaurant = new Restaurant("Versus",Address.STRUGA,RestaurantType.MEDITERRANEAN,true);
                review = new Review(5,"Nice",user,restaurant);

                review.incrementLikes();
    }

    @Test
    public void incrementLikes() {

        assertEquals(1,review.getLikes());
    }
}