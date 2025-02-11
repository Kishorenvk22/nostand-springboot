package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CategoryDTO;
import com.example.demo.service.CategoryService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryservice;

	@GetMapping("/getAllCategories")
	public ResponseEntity<List<CategoryDTO>> getAllCategories() {
		return ResponseEntity.ok(categoryservice.getAllCategories());
	}

	@GetMapping("/getcategoryByrestaurant/{restaurantid}")
	public ResponseEntity<?> getRestaurantById(@PathVariable String restaurantid) {

		return ResponseEntity.ok(categoryservice.getCategoriesByRestaurantId(restaurantid));
	}

	@PostMapping("/addcategory")
	public ResponseEntity<CategoryDTO> addCategory(@RequestBody CategoryDTO categoryDTO) {

		return ResponseEntity.ok(categoryservice.Addcategories(categoryDTO));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable String id) {
		categoryservice.deleteCategory(id);
		return ResponseEntity.ok("Category deleted successfully");
	}

}
