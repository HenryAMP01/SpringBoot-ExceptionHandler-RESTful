package com.study.exceptions.model.dao;

import java.util.List;

import com.study.exceptions.model.entity.Review;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReviewDao extends JpaRepository<Review, Long>{

    public List<Review> findByBookId(Long bookId);

    public List<Review> findByUserId(Long userId);
    
}
