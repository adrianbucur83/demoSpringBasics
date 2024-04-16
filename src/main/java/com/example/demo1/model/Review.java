package com.example.demo1.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Entity
@Table(name = "reviews")
@Data
@SuperBuilder
public class Review {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private String reviewMsg;
    private LocalDateTime date;
    private String userName;

    public Review() {

    }

}
