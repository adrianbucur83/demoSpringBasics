package com.example.demo1.controller;

import com.example.demo1.model.WelcomeMessage;
import com.example.demo1.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/reviews")
public class ProductReviewsController {



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
    public String getReviews() {
        return "get-reviews";
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
