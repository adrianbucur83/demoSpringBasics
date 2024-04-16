package com.example.demo1.model.dto;

import com.example.demo1.model.Review;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReviewUpdateDto {
    private Integer id;
    private String reviewMsg;
    private LocalDateTime date;
    private String userName;

    public static Review toObject(ReviewUpdateDto reviewDto) {
        Review review = new Review();
        review.setId(reviewDto.getId());
        review.setReviewMsg(reviewDto.getReviewMsg());
        review.setDate(reviewDto.getDate());
        review.setUserName(reviewDto.getUserName());
        return review;

    }

    public static ReviewUpdateDto toDto(Review review) {
        ReviewUpdateDto reviewDto = new ReviewUpdateDto();
        reviewDto.setId(review.getId());
        reviewDto.setReviewMsg(review.getReviewMsg());
        reviewDto.setDate(review.getDate());
        reviewDto.setUserName(review.getUserName());
        return reviewDto;
    }
}
