package com.jobpackage.jobpackage.Review;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/company/{cid}")
public class ReviewController {
    
    ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("addreview")
    public Review addReview(@RequestBody Review review,@PathVariable int cid) {
        return reviewService.createReview(review,cid);
    }

    @GetMapping("getallreview")
    public List<Review> getAllReview(@PathVariable int cid) {
        return reviewService.getAllReviews(cid);
    }

    @GetMapping("getreviewbyid/{rid}")
    public Review getReviewById(@PathVariable int cid,@PathVariable int rid) {
        return reviewService.getReviewById(cid,rid);
    }

    @PutMapping("updatereview/{rid}")
    public Review updateReview(@PathVariable int cid,@PathVariable int rid, @RequestBody Review review) {
        return reviewService.updateReview(cid,rid, review);
    }

    @DeleteMapping("deletereview/{id}")
    public void deleteReview(@PathVariable int id) {
        reviewService.deleteReview(id);
    }
    
}
