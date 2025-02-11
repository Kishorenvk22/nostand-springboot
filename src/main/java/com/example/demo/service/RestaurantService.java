package com.example.demo.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.RestaurantDTO;
import com.example.demo.entity.Restaurant;
import com.example.demo.respository.RestaurantRepository;

@Service
public class RestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepository;

	public RestaurantDTO getRestaurantById(String id) {

		Optional<Restaurant> restaurantOptional = restaurantRepository.findById(id);

		if (restaurantOptional.isPresent()) {
			return convertToDTO(restaurantOptional.get());
		} else {
			return null;
		}

	}

	// Fetch all restaurants
	public List<RestaurantDTO> getAllRestaurants() {
		List<Restaurant> restaurants = restaurantRepository.findAll();
		return restaurants.stream().map(this::convertToDTO) // Convert each Restaurant to RestaurantDTO
				.collect(Collectors.toList());
	}

	// Create a new restaurant
	public RestaurantDTO createRestaurant(Restaurant restaurant) {
		Restaurant savedRestaurant = restaurantRepository.save(restaurant);
		return convertToDTO(savedRestaurant); // Convert to DTO and return
	}

	// Delete a restaurant
	public void deleteRestaurant(String id) {
		restaurantRepository.deleteById(id);
	}

	private RestaurantDTO convertToDTO(Restaurant restaurant) {
		// Directly using getters from Restaurant entity
		return new RestaurantDTO(restaurant.getId(), restaurant.getName(), restaurant.getCategory(),
				restaurant.getImageUrl(), restaurant.getCuisine(), restaurant.getRating(), restaurant.getDeliveryTime(),
				restaurant.getAdminUsername(), restaurant.getAdminPassword());
	}
}
