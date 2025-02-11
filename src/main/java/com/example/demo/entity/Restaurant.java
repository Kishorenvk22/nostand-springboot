package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "restaurants")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {

	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "name")
	private String name;

	@Column(name = "category")
	private String category;

	@Column(name = "image_url")
	private String imageUrl;

	@Column(name = "cuisine")
	private String cuisine;

	@Column(name = "rating")
	private Double rating;

	@Column(name = "delivery_time")
	private String deliveryTime;

	@Column(name = "admin_username")
	private String adminUsername;

	@Column(name = "admin_password")
	private String adminPassword;

}
