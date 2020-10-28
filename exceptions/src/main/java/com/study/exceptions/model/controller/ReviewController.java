package com.study.exceptions.model.controller;

import java.util.List;

import javax.validation.Valid;

import com.study.exceptions.model.dto.ReviewDTO;
import com.study.exceptions.model.entity.Review;
import com.study.exceptions.model.mapper.ReviewMapper;
import com.study.exceptions.model.service.IReviewService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RequestMapping(value = "/api/reviews")
@CrossOrigin("*")
@RestController
public class ReviewController {

    @Autowired private IReviewService reviewService;

    @Autowired private ReviewMapper reviewMapper;

    @GetMapping
    public List<ReviewDTO> findAllReviews() {
        return reviewMapper.toListDTO(reviewService.findAllReviews());
    }

    @GetMapping(value = "/{id}")
    public ReviewDTO findByReviewId(@PathVariable("id") Long id) {
        return reviewMapper.toDTO(reviewService.findByReviewId(id));
    }

    @PostMapping
    public ReviewDTO saveReview(@Valid @RequestBody Review review) {
        return reviewMapper.toDTO(reviewService.saveReview(review));
    }

    @PutMapping(value = "/{id}")
    public ReviewDTO updateReview(@Valid @RequestBody Review review, @PathVariable("id") Long id){

        Review reviewFound = reviewService.findByReviewId(id);

        if(reviewFound == null){
            
        }

        //reviewFound.setId(review.getId());
        reviewFound.setCommentary(review.getCommentary());
        reviewFound.setBook(review.getBook());
        reviewFound.setUser(review.getUser());

        return reviewMapper.toDTO(reviewService.saveReview(reviewFound));

    }

    @DeleteMapping(value = "/{id}")
    public void deleteByReviewId(@PathVariable("id") Long id){
        reviewService.deleteByReviewId(id);

    }

    // Other methods

    @GetMapping(value = "/book/{bookId}")
    public List<ReviewDTO> findByBookId(@PathVariable("bookId") Long bookId) {
        return reviewMapper.toListDTO(reviewService.findByBookId(bookId));
    }

    @GetMapping(value = "/user/{userId}")
    public List<ReviewDTO> findByUserId(@PathVariable("userId") Long userId) {
        return reviewMapper.toListDTO(reviewService.findByUserId(userId));
    }
    
    
}