package com.awdhx.JobApp.review.impl;

import com.awdhx.JobApp.company.entity.Company;
import com.awdhx.JobApp.company.service.CompanyService;
import com.awdhx.JobApp.review.entity.Review;
import com.awdhx.JobApp.review.repository.ReviewRepository;
import com.awdhx.JobApp.review.service.ReviewService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;
    private CompanyService companyService;

    public ReviewServiceImpl(ReviewRepository reviewRepository,CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService=companyService;
    }

    @Override
    public List<Review> getAllReviewsByCompanyId(Long comapnyId) {
        List<Review> reviews=reviewRepository.findByCompanyId(comapnyId);
       return reviews;
    }

    @Override
    public void addReview(Long companyId, Review review){
        Company company=companyService.getCompanyById(companyId);
        if(company != null) {
            review.setCompany(company);
            reviewRepository.save(review);
        }
    }

    @Override
    public Review getReviewById(Long companyId, Long reviewId){
        return reviewRepository.findByCompanyIdAndId(companyId, reviewId)
                .orElse(null);

    }

    @Override
    @Transactional
    public boolean deleteReviewById(Long companyId, Long reviewId){
        return reviewRepository.deleteByCompanyIdAndId(companyId, reviewId)>0;
    }

    @Override
    public boolean updatedReview(Long companyId, Long reviewId, Review updatedReview) {

        Review review = reviewRepository.findByCompanyIdAndId(companyId, reviewId)
                .orElse(null);

        if (review != null) {

            Optional.ofNullable(updatedReview.getTitle())
                    .ifPresent(review::setTitle);

            Optional.ofNullable(updatedReview.getDescription())
                    .ifPresent(review::setDescription);

            Optional.ofNullable(updatedReview.getRating())
                    .ifPresent(review::setRating);

            // IMPORTANT: save the updated existing object
            reviewRepository.save(review);

            return true;
        }

        return false;
    }

}
