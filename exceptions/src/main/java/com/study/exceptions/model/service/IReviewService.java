package com.study.exceptions.model.service;

import java.util.List;

import com.study.exceptions.model.entity.Review;

public interface IReviewService {

    public Review findByReviewId(Long id);

    public List<Review> findAllReviews();

    public Review saveReview(Review author);

    public void deleteByReviewId(Long id); 

    // Other methods

    public List<Review> findByBookId(Long bookId);

    public List<Review> findByUserId(Long userId);
    
}
