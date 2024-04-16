package com.example.demo1.model.dto;

import com.example.demo1.model.Review;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReviewDto {
    private String reviewMsg;
    private LocalDateTime date;
    private String userName;

    public Review toObject(ReviewDto reviewDto) {
       Review review = new Review();
       review.setReviewMsg(reviewDto.getReviewMsg());
       review.setDate(reviewDto.getDate());
       review.setUserName(reviewDto.getUserName());
        return review;
    }

    public ReviewDto toDto(Review review) {
        ReviewDto reviewDto = new ReviewDto();
        reviewDto.setReviewMsg(review.getReviewMsg());
        reviewDto.setDate(review.getDate());
        reviewDto.setUserName(review.getUserName());
        return reviewDto;

    }
    //        BeanUtils.copyProperties(delivery, deliveryDto);
}
