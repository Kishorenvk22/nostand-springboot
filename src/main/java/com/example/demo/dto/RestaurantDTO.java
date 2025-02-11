package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantDTO {

	private String id;
	private String name;
	private String category;
	private String imageUrl;
	private String cuisine;
	private Double rating;
	private String deliveryTime;
	private String adminUsername;
	private String adminPassword;

}
