package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ItemDTO;
import com.example.demo.entity.Category;
import com.example.demo.entity.Item;
import com.example.demo.entity.Restaurant;
import com.example.demo.respository.ItemRespository;
import com.example.demo.respository.RestaurantRepository;
import com.example.demo.respository.categoryRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRespository itemRepository;

	@Autowired
	private RestaurantRepository restaurantRepository;

	@Autowired
	private categoryRepository categoryRepository;

//    public ItemService(ItemRespository itemRepository, RestaurantRepository restaurantRepository, categoryRepository categoryRepository) {
//        this.itemRepository = itemRepository;
//        this.restaurantRepository = restaurantRepository;
//        this.categoryRepository = categoryRepository;
//    }

	private ItemDTO convertToDTO(Item item) {
		return new ItemDTO(item.getId(), item.getName(), item.getPrice(), item.getImageUrl(), item.isAvailable(),
				item.getCategory().getCategoryId(), item.getRestaurant().getId());
	}

	public List<ItemDTO> getAllItems() {
		return itemRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	public List<ItemDTO> getItemsByRestaurant(String restaurantId) {
		return itemRepository.findByRestaurantId(restaurantId).stream().map(this::convertToDTO)
				.collect(Collectors.toList());
	}

	public List<ItemDTO> getItemsByCategory(String categoryId) {
		return itemRepository.findByCategory_CategoryId(categoryId).stream().map(this::convertToDTO)
				.collect(Collectors.toList());
	}

	public ItemDTO addItem(ItemDTO itemDTO) {
		Restaurant restaurant = restaurantRepository.findById(itemDTO.getRestaurantId())
				.orElseThrow(() -> new RuntimeException("Restaurant not found"));

		Category category = categoryRepository.findById(itemDTO.getCategoryId())
				.orElseThrow(() -> new RuntimeException("Category not found"));

		Item item = new Item(itemDTO.getId(), itemDTO.getName(), itemDTO.getPrice(), itemDTO.getImageUrl(),
				itemDTO.isAvailable(), category, restaurant);

		return convertToDTO(itemRepository.save(item));
	}

	public ItemDTO updateItemAvailability(String id, boolean available) {
		Item item = itemRepository.findById(id).orElseThrow(() -> new RuntimeException("Item not found"));

		item.setAvailable(available);
		return convertToDTO(itemRepository.save(item));
	}

	public void deleteItem(String id) {
		if (!itemRepository.existsById(id)) {
			throw new RuntimeException("Item not found");
		}
		itemRepository.deleteById(id);
	}
}
