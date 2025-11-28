package com.awdhx.JobApp.review.repository;

import com.awdhx.JobApp.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {
    List<Review> findByCompanyId(Long id);
    Optional<Review> findByCompanyIdAndId(Long companyId, Long reviewId);
    long deleteByCompanyIdAndId(Long companyId, Long reviewId);
}
