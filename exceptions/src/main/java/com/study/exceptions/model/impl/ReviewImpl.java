package com.study.exceptions.model.impl;

import java.util.List;

import com.study.exceptions.exception.custom.ResourceNotFoundException;
import com.study.exceptions.model.dao.IReviewDao;
import com.study.exceptions.model.entity.Review;
import com.study.exceptions.model.service.IReviewService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReviewImpl implements IReviewService {

    @Autowired private IReviewDao reviewDao;

    @Override
    @Transactional(readOnly = true)
    public Review findByReviewId(Long id) {
        return reviewDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Review> findAllReviews() {
        return reviewDao.findAll();
    }

    @Override
    @Transactional
    public Review saveReview(Review review) {
        return reviewDao.save(review);
    }

    @Override
    @Transactional
    public void deleteByReviewId(Long id) {
        reviewDao.deleteById(id);
    }

    // Other methods

    @Override
    @Transactional(readOnly = true)
    public List<Review> findByBookId(Long bookId) {
        return reviewDao.findByBookId(bookId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Review> findByUserId(Long userId) {
        return reviewDao.findByUserId(userId);
    }
    
}
