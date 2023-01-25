package com.restorant.backend.Service;

import com.restorant.backend.POJO.Address;
import com.restorant.backend.POJO.Restaurant;
import com.restorant.backend.POJO.RestaurantType;

import java.util.List;
import java.util.Optional;

public interface RestaurantService {

    Restaurant create(Restaurant restaurant);
    Optional<Restaurant> findById(Integer id);
    List<Restaurant> findAll();
    List<Restaurant> findByAddress(Address address);
    List<Restaurant> findByType(RestaurantType restaurantType);
    List<Restaurant> findByName(String name);

    void deleteRestaurant(Integer id);

    Restaurant update(Restaurant restaurantToUpdate);

    List<Restaurant> findByCityAndDoDelivery(Address address, boolean dodelivery);
}
