package com.awdhx.JobApp.review.service;

import com.awdhx.JobApp.review.entity.Review;

import java.util.List;

public interface ReviewService {

    List<Review> getAllReviewsByCompanyId(Long companyId);

    void addReview(Long companyId, Review review);

    Review getReviewById(Long companyId, Long reviewId);

    boolean deleteReviewById(Long companyId, Long reviewId);

    boolean updatedReview(Long companyId, Long reviewId, Review updatedReview);
}
