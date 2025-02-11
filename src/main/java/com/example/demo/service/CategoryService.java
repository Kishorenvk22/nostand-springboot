package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CategoryDTO;
import com.example.demo.entity.Category;
import com.example.demo.entity.Restaurant;
import com.example.demo.respository.RestaurantRepository;
import com.example.demo.respository.categoryRepository;

@Service
public class CategoryService {

	@Autowired
	private categoryRepository categoryrepository;

	@Autowired
	private RestaurantRepository restaurantrepository;

	private CategoryDTO convertToDTO(Category category) {
		return new CategoryDTO(category.getCategoryId(), category.getCategory_name(), category.getRestaurant().getId());
	}

	public List<CategoryDTO> getAllCategories() {

		return categoryrepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());

	}

	public List<CategoryDTO> getCategoriesByRestaurantId(String RestaurantId) {
		return categoryrepository.findByRestaurantId(RestaurantId).stream().map(this::convertToDTO)
				.collect(Collectors.toList());
	}

	public CategoryDTO Addcategories(CategoryDTO categoryDTO) {

		Restaurant restaurant = restaurantrepository.findById(categoryDTO.getRestaurant_id())
				.orElseThrow(() -> new RuntimeException("Restaurant Not Found"));

		Category category = new Category();
		category.setCategoryId(categoryDTO.getId());
		category.setCategory_name(categoryDTO.getCategory_name());
		category.setRestaurant(restaurant);

		Category savedCategory = categoryrepository.save(category);
		return convertToDTO(savedCategory);

	}

	public void deleteCategory(String id) {
		categoryrepository.deleteById(id);
	}

}
