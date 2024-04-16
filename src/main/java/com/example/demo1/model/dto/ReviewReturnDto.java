package com.example.demo1.model.dto;

import com.example.demo1.model.Review;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReviewReturnDto {
    private Integer id;
    private String reviewMsg;
    private LocalDateTime date;
    private String userName;

    public static Review toObject(ReviewReturnDto reviewDto) {
        Review review = new Review();
        review.setId(reviewDto.getId());
        review.setReviewMsg(reviewDto.getReviewMsg());
        review.setDate(reviewDto.getDate());
        review.setUserName(reviewDto.getUserName());
        return review;

    }

    public static ReviewReturnDto toDto(Review review) {
        ReviewReturnDto reviewDto = new ReviewReturnDto();
        reviewDto.setId(review.getId());
        reviewDto.setReviewMsg(review.getReviewMsg());
        reviewDto.setDate(review.getDate());
        reviewDto.setUserName(review.getUserName());
        return reviewDto;
    }
}
