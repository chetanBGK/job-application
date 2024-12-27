package com.jobpackage.jobpackage.Review;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepo extends JpaRepository<Review,Integer>{
    List<Review> findByCompanyId(int id);
}
