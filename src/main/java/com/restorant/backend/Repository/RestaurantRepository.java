package com.restorant.backend.Repository;

import com.restorant.backend.POJO.Address;
import com.restorant.backend.POJO.Restaurant;
import com.restorant.backend.POJO.RestaurantType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Integer> {

    @Query("SELECT r from Restaurant r where r.address = :address")
    List<Restaurant> findByAddress(@Param("address") Address address);

    @Query("SELECT r from Restaurant r where r.type = :restaurantType")
    List<Restaurant> findByType(@Param("restaurantType") RestaurantType restaurantType);

    @Query("SELECT r FROM Restaurant r WHERE r.name LIKE %:name%")
    List<Restaurant> findByName(@Param("name") String name);

    List<Restaurant> findRestaurantsByAddressAndDoDelivery(Address address, boolean doDelivery);
}
