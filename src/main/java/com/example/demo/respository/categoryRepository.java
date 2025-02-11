package com.example.demo.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Category;

@Repository
public interface categoryRepository extends JpaRepository<Category, String> {

	List<Category> findByRestaurantId(String restaurantId);

}
