package com.jobpackage.jobpackage.Review.ReviewImpl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobpackage.jobpackage.Company.Company;
import com.jobpackage.jobpackage.Company.CompanyService;
import com.jobpackage.jobpackage.Review.Review;
import com.jobpackage.jobpackage.Review.ReviewRepo;
import com.jobpackage.jobpackage.Review.ReviewService;

@Service
public class ReviewImpl implements ReviewService{

    @Autowired
    ReviewRepo reviewRepo;
    @Autowired
    CompanyService companyService;
 
    @Override
    public Review createReview(Review review,int cid) {
        Company company = companyService.getCompanyById(cid);
        if (Objects.isNull(company)) {
            throw new RuntimeException("Company not found");
            
        }
        review.setCompany(company);
        return reviewRepo.save(review);
    }

    @Override
    public Review getReviewById(int cid,int rid) {
        List<Review> reviews = reviewRepo.findByCompanyId(cid);
        if (reviews.isEmpty()) {
            throw new RuntimeException("No reviews found");
        }
        return reviews.stream()
        .filter(review->review.getId()==rid)
        .findFirst()
        .orElseThrow(()->new RuntimeException("Review not found"));

        
        // return reviewRepo.findById(rid).get();
    }

    @Override
    public Review updateReview(int cid, int rid, Review review) {
        List<Review> reviews= reviewRepo.findByCompanyId(cid); 
        Review review1= reviews.stream().filter(rew->rew.getId()==rid)
        .findFirst()
        .orElseThrow(()-> new RuntimeException());

        review1.setTitle(review.getTitle());
        review1.setDescription(review.getDescription());
        review1.setRating(review.getRating());
        return reviewRepo.save(review1);

    }

    @Override
    public void deleteReview(int id) {
        reviewRepo.deleteById(id);
    }

    @Override
    public List<Review> getAllReviews(int cid) {
        List<Review> reviews = reviewRepo.findByCompanyId(cid);
        return reviews;
    }
    
}
