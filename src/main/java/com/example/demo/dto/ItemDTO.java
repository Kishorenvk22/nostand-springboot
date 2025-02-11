package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {

	private String id;
	private String name;
	private double price;
	private String imageUrl;
	private boolean available;
	private String categoryId;
	private String restaurantId;

}
