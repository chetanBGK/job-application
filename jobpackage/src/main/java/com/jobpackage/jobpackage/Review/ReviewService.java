package com.jobpackage.jobpackage.Review;

import java.util.List;

public interface ReviewService {
    Review createReview(Review review, int cid);
    Review getReviewById(int cid,int rid);
    Review updateReview(int cid, int rid,Review review);
    void deleteReview(int id);
    List<Review> getAllReviews(int cid);
    
}
