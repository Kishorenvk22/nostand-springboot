package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ItemDTO;
import com.example.demo.service.ItemService;

@RestController
@RequestMapping("/api/items")
public class ItemController {

	@Autowired
	private ItemService itemService;

	@GetMapping("/getAllItems")
	public ResponseEntity<List<ItemDTO>> getAllItems() {
		return ResponseEntity.ok(itemService.getAllItems());
	}

	@GetMapping("/restaurant/{restaurantId}")
	public ResponseEntity<List<ItemDTO>> getItemsByRestaurant(@PathVariable String restaurantId) {
		return ResponseEntity.ok(itemService.getItemsByRestaurant(restaurantId));
	}

	@GetMapping("/category/{categoryId}")
	public ResponseEntity<List<ItemDTO>> getItemsByCategory(@PathVariable String categoryId) {
		return ResponseEntity.ok(itemService.getItemsByCategory(categoryId));
	}

	@PostMapping
	public ResponseEntity<ItemDTO> addItem(@RequestBody ItemDTO itemDTO) {
		return ResponseEntity.ok(itemService.addItem(itemDTO));
	}

	@PutMapping("/{id}/availability")
	public ResponseEntity<ItemDTO> updateItemAvailability(@PathVariable String id, @RequestParam boolean available) {
		return ResponseEntity.ok(itemService.updateItemAvailability(id, available));
	}

	@DeleteMapping("/{id}/delete")
	public ResponseEntity<String> deleteItem(@PathVariable String id) {
		itemService.deleteItem(id);
		return ResponseEntity.ok("Item deleted successfully");
	}

}
