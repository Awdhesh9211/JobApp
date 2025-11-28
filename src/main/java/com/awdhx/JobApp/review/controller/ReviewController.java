package com.awdhx.JobApp.review.controller;

import com.awdhx.JobApp.review.entity.Review;
import com.awdhx.JobApp.review.service.ReviewService;
import jakarta.annotation.Nullable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/review/companies")
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<List<Review>> getAllReviewsByCompanyId(@PathVariable Long companyId){
        return ResponseEntity.ok(reviewService.getAllReviewsByCompanyId(companyId));
    }


    @PostMapping("/{companyId}")
    public ResponseEntity<String> getReviewService(@PathVariable Long companyId,@RequestBody Review review) {
        reviewService.addReview(companyId,review);
        return new ResponseEntity<>("review added successfully!",HttpStatus.OK);
    }

    @GetMapping("/{companyId}/reviewid/{reviewId}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long companyId,
                                                @PathVariable Long reviewId) {
        Review review = reviewService.getReviewById(companyId, reviewId);
        if (review != null) {
            return new ResponseEntity<>(review, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{companyId}/reviewid/{reviewId}")
    public ResponseEntity<String> deleteReviewById(@PathVariable Long companyId,
                                                @PathVariable Long reviewId) {
        boolean isdelete = reviewService.deleteReviewById(companyId, reviewId);
        if (isdelete) {
            System.out.println("DEEEEDHHH");
            return new ResponseEntity<>("deleted success!", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{companyId}/reviewid/{reviewId}")
    public ResponseEntity<String> updateReviewById(@PathVariable Long companyId,
                                                   @PathVariable Long reviewId,@RequestBody Review review) {
        boolean isupdated = reviewService.updatedReview(companyId, reviewId,review);
        if (isupdated) {
            return new ResponseEntity<>("updated success!", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }




}
