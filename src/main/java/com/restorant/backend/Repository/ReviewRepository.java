package com.restorant.backend.Repository;

import com.restorant.backend.POJO.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Integer> {

    @Query("SELECT r FROM Review r WHERE r.restaurant.id = :rid")
    List<Review> findByRestaurant(@Param("rid") Integer rid);

    @Query("SELECT r FROM Review r WHERE r.user.id = :uid")
    List<Review> findByUser(@Param("uid") Integer uid);

}
