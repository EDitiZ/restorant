package com.restorant.backend.Service;

import com.restorant.backend.POJO.Review;
import com.restorant.backend.POJO.User;

import java.util.List;
import java.util.Optional;

public interface ReviewService {

    Review create(Review review);
    Optional<Review> findById(Integer id);
    List<Review> findAllReviewsByRestaurant(Integer Rid);

    List<Review> findAllReviewsByUser(Integer Uid);
    Review likeReview(Review review, User user);

    Review unLikeReview(Review review, User user);
}
