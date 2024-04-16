package com.example.demo1.repository;


import com.example.demo1.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewsRepository extends JpaRepository<Review, Integer> {
    List<Review> getAllByUser(String userName);

    void deleteAllByUser(String userName);
}
