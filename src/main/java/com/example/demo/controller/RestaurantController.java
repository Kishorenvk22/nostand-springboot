package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.RestaurantDTO;
import com.example.demo.entity.Restaurant;
import com.example.demo.service.RestaurantService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantservice;

	@GetMapping("/allrestaurant")
	public ResponseEntity<List<RestaurantDTO>> getAllrestaurant() {

		List<RestaurantDTO> restaurantDTOs = restaurantservice.getAllRestaurants();
		return ResponseEntity.ok(restaurantDTOs);

	}

	@GetMapping("/test")
	public String test() {
		return "Madhesh";

		// TODO Auto-generated method stub

	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getRestaurantById(@PathVariable String id) {

		RestaurantDTO restaurantDTO = restaurantservice.getRestaurantById(id);

		if (restaurantDTO != null) {
			return ResponseEntity.ok(restaurantDTO);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Restaurant not found with id: " + id);
		}
	}

	@PostMapping("/addRestaurant")
	public ResponseEntity<RestaurantDTO> createRestaurant(@RequestBody Restaurant restaurant) {

		RestaurantDTO createdReataurant = restaurantservice.createRestaurant(restaurant);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdReataurant);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteRestaurant(@PathVariable String id) {
		restaurantservice.deleteRestaurant(id);
		return ResponseEntity.ok("Deleted");
	}

}
