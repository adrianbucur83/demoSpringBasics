package com.example.demo1.controller;

import com.example.demo1.model.Review;
import com.example.demo1.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reviews")
public class ProductReviewsController {

private final ReviewService reviewService;
@Autowired
    public ProductReviewsController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }


    //CRUD
    @GetMapping("/review-form")
    public String displayReviewForm(Model model) {
        model.addAttribute("review", new Review());

        return "reviews/review-form";
    }

    ;

    @PostMapping("/your-review")
    public String createReviews(@RequestParam(required = false) @ModelAttribute Review review,
                                Model model) {
        model.addAttribute("review", review);

        return "reviews/create-reviews";
    }

    ;

    @GetMapping("/all-reviews")
    public String getReviews(Model model) {
        model.addAttribute("reviews", reviewService.getAllReviews());
        return "reviews/get-reviews";
    }

    ;

    @PutMapping("/update-review/{id}")
    public String updateReviews() {
        return "update-reviews";
    }

    ;

    @DeleteMapping("delete-review/{id}")
    public String deleteReviews() {
        return "delete-review";
    }

    ;
}
