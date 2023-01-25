package com.restorant.backend.Service;

import com.restorant.backend.POJO.Review;
import com.restorant.backend.POJO.User;
import com.restorant.backend.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultReviewService implements ReviewService{

    @Autowired
    ReviewRepository reviewRepository;
    @Override
    public Review create(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Optional<Review> findById(Integer id) {
        return reviewRepository.findById(id);
    }

    @Override
    public List<Review> findAllReviewsByRestaurant(Integer Rid) {
        return reviewRepository.findByRestaurant(Rid);
    }

    @Override
    public List<Review> findAllReviewsByUser(Integer Uid) {
        return reviewRepository.findByUser(Uid);
    }

    @Override
    public Review likeReview(Review review, User user) {
        if (review.getLikedBy().contains(user)){
            return null;
        }

        review.getLikedBy().add(user);
        review.incrementLikes();
        reviewRepository.save(review);
        return review;
    }


}
