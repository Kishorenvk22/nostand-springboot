package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
    @Column(nullable = false,name="name")
	private String name;
	
    @Column(nullable = false, unique = true,name="mobile")
	private String mobile;
	
    @Column(nullable = false, unique = true,name="email")
	private String email;
	
    @Column(nullable = false,name="password")
	private String password;
	
}
