package com.restorant.backend.Controller;

import com.restorant.backend.POJO.Address;
import com.restorant.backend.POJO.EntityNotFoundException;
import com.restorant.backend.POJO.Restaurant;
import com.restorant.backend.POJO.RestaurantType;
import com.restorant.backend.PojoInput.RestaurantInput;
import com.restorant.backend.Service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.InvalidClassException;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;


    //Creating a restaurant
    @PostMapping("/post")
    public ResponseEntity<Restaurant> create(@RequestBody RestaurantInput input) {

        String name = input.getName();
        Address address = input.getAddress();
        RestaurantType type = input.getType();
        boolean doDelivery = input.isDoDelivery();

        Restaurant restaurant = new Restaurant(name, address, type, doDelivery);
        restaurantService.create(restaurant);
        return new ResponseEntity<>(restaurant, HttpStatus.CREATED);

    }

    //Getting all the restaurants in the Db
    @GetMapping("/post")
    public ResponseEntity<List<Restaurant>> findAll() {
        List<Restaurant> restaurants = restaurantService.findAll();
        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }

    @GetMapping("/post/one/{id}")
    public ResponseEntity<Restaurant> findOneById(@PathVariable Integer id){

        Restaurant restaurant = restaurantService.findById(id).orElseThrow();

        return new ResponseEntity<>(restaurant,HttpStatus.OK);
    }

    //Getting all the restaurant in a specified City
    @GetMapping("/city/{address}")
    public ResponseEntity<List<Restaurant>> findAllByAddress(@PathVariable String address) {
        Address addressEnum = Address.valueOf(address.toUpperCase());
        List<Restaurant> restaurants = restaurantService.findByAddress(addressEnum);

        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }

    //Getting all restaurants of the same restuarnt type
    @GetMapping("/type/{type}")
    public ResponseEntity<List<Restaurant>> findAllByType(@PathVariable String type) {
        RestaurantType restaurantType = RestaurantType.valueOf(type.toUpperCase());
        List<Restaurant> restaurants = restaurantService.findByType(restaurantType);

        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }

    //Getting restuarants by their name
    @GetMapping("/post/{name}")
    public ResponseEntity<List<Restaurant>> findAllByName(@PathVariable String name) {
        List<Restaurant> restaurants = restaurantService.findByName(name);

        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }


    //Deleting a restaurant by their id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable Integer id) {
        restaurantService.deleteRestaurant(id);

        return ResponseEntity.noContent().build();
    }

    //Updating an existing restaurant
    @PutMapping("/update/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable Integer id, @RequestBody RestaurantInput input) {
        Restaurant restaurant = restaurantService.findById(id).orElseThrow();

        restaurant.setName(input.getName());
        restaurant.setAddress(input.getAddress());
        restaurant.setType(input.getType());
        restaurant.setDoDelivery(input.isDoDelivery());

        Restaurant updated = restaurantService.update(restaurant);

        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    //Getting restaurants in one city and sorting them by price
    @GetMapping("/cityprice/{address}/{sorter}")
    public ResponseEntity<List<Restaurant>> sortByPriceOnCity(@PathVariable String address, @PathVariable String sorter) {

        Address addressEnum = Address.valueOf(address.toUpperCase());
        List<Restaurant> restaurant = restaurantService.findByAddress(addressEnum);

        if (restaurant.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        if (sorter.contains("asc"))
            restaurant.sort(Comparator.comparing(Restaurant::getAveragePrice));
        else
            restaurant.sort(Comparator.comparing(Restaurant::getAveragePrice).reversed());

        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    //Getting restaurants on a city and sorting them by rating
    @GetMapping("/cityrating/{address}/{sorter}")
    public ResponseEntity<List<Restaurant>> sortByRatingOnCity(@PathVariable String address, @PathVariable String sorter) {

        Address addressEnum = Address.valueOf(address.toUpperCase());
        List<Restaurant> restaurant = restaurantService.findByAddress(addressEnum);

        if (restaurant.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        if (sorter.contains("asc"))
            restaurant.sort(Comparator.comparing(Restaurant::getRating));
        else
            restaurant.sort(Comparator.comparing(Restaurant::getRating).reversed());

        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    @GetMapping("/deliveries/{address}")
    public ResponseEntity<List<Restaurant>> findByAddressAndDelivery(@PathVariable String address, @RequestParam boolean doDelivery){
        Address address1 = Address.valueOf(address.toUpperCase());
        List<Restaurant> deliveries = restaurantService.findByCityAndDoDelivery(address1,doDelivery);

        return new ResponseEntity<>(deliveries,HttpStatus.OK);
    }
}
