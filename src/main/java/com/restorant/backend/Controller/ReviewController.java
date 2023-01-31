package com.restorant.backend.Controller;

import com.restorant.backend.POJO.*;
import com.restorant.backend.PojoInput.ReviewInput;
import com.restorant.backend.Service.RestaurantService;
import com.restorant.backend.Service.ReviewService;
import com.restorant.backend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    ReviewService reviewService;
    @Autowired
    RestaurantService restaurantService;
    @Autowired
    UserService userService;


    @PostMapping("/post")
    public ResponseEntity<Review> create(@RequestBody ReviewInput input) throws RestaurantNotFoundException, UserNotFoundException, InvalidRatingException {

        int rating = input.getRating();;
        String text = input.getText();
        Integer Uid = input.getUid();
        Integer Rid = input.getRid();

        Restaurant restaurant = restaurantService.findById(Rid).orElseThrow(() -> new RestaurantNotFoundException(Rid));
        User user = userService.findById(Uid).orElseThrow(() -> new UserNotFoundException(Uid));

        Review review = new Review(rating, text, user, restaurant);
        review.setRating(rating);
        restaurant.addRating(review.getRating());
        reviewService.create(review);


        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/post/{rid}")
    public ResponseEntity<List<Review>> findByRestaurant(@PathVariable Integer rid) {
        List<Review> reviews = reviewService.findAllReviewsByRestaurant(rid);

        if (!reviews.isEmpty())
            return new ResponseEntity<>(reviews,HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/post/user/{uid}")
    public ResponseEntity<List<Review>> findByUser(@PathVariable Integer uid){
        List<Review> reviews = reviewService.findAllReviewsByUser(uid);

        if (reviews.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(reviews,HttpStatus.OK);
    }

    @PutMapping("/{id}/like/{uid}")
    public ResponseEntity<Review> likeReview(@PathVariable Integer id, @PathVariable Integer uid)
                                  throws ReviewNotFoundException, UserNotFoundException{

        Review review = reviewService.findById(id).orElseThrow(() -> new ReviewNotFoundException(id));
        User user = userService. findById(uid).orElseThrow(() -> new UserNotFoundException(uid));
        Review liked = reviewService.likeReview(review,user);
        if (liked!=null){
            return new ResponseEntity<>(liked,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @PutMapping("/{id}/unlike/{Uid}")
    public ResponseEntity<Review> unLikeReview(@PathVariable Integer id, @PathVariable Integer Uid)
                                   throws ReviewNotFoundException, UserNotFoundException{

        Review review = reviewService.findById(id).orElseThrow(() -> new ReviewNotFoundException(id));
        User user = userService.findById(Uid).orElseThrow(() -> new UserNotFoundException(Uid));

        Review unLiked = reviewService.unLikeReview(review,user);
        if (unLiked!=null)
            return new ResponseEntity<>(unLiked, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
}
