package com.example.demo.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Item;

@Repository
public interface ItemRespository extends JpaRepository<Item, String> {

	List<Item> findByRestaurantId(String restaurantId);

	List<Item> findByCategory_CategoryId(String category_id); // Fetch items by category ID

//    List<Item> findByCategoryId(String category_id);
}
