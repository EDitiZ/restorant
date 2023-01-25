package com.restorant.backend.Service;

import com.restorant.backend.POJO.Address;
import com.restorant.backend.POJO.Restaurant;
import com.restorant.backend.POJO.RestaurantType;
import com.restorant.backend.Repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DefaultRestaurantService implements RestaurantService{

    @Autowired
    RestaurantRepository restaurantRepository;
    @Override
    public Restaurant create(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Optional<Restaurant> findById(Integer id) {
        return restaurantRepository.findById(id);
    }

    @Override
    public List<Restaurant> findAll() {
        List<Restaurant> restaurants = new ArrayList<>();
        restaurantRepository.findAll().forEach(restaurants::add);
        return restaurants;
    }

    @Override
    public List<Restaurant> findByAddress(Address address) {
        return restaurantRepository.findByAddress(address);
    }

    @Override
    public List<Restaurant> findByType(RestaurantType restaurantType) {
        return restaurantRepository.findByType(restaurantType);
    }

    @Override
    public List<Restaurant> findByName(String name) {
        return restaurantRepository.findByName(name);
    }

    @Override
    public void deleteRestaurant(Integer id) {
        restaurantRepository.deleteById(id);
    }

    @Override
    public Restaurant update(Restaurant restaurantToUpdate) {
        return restaurantRepository.save(restaurantToUpdate);
    }

    @Override
    public List<Restaurant> findByCityAndDoDelivery(Address address, boolean dodelivery) {
        return restaurantRepository.findRestaurantsByAddressAndDoDelivery(address,dodelivery);
    }
}
