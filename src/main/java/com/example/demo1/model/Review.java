package com.example.demo1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

public class Review {
    private int id;
    private String reviewMsg;
    private LocalDate date;
    private String userName;

    public Review() {

    }

    public String getReviewMsg() {
        return reviewMsg;
    }

    public void setReviewMsg(String reviewMsg) {
        this.reviewMsg = reviewMsg;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Review(String reviewMsg, String userName) {
        this.reviewMsg = reviewMsg;
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewMsg='" + reviewMsg + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
