package com.example.demo.entity;

import java.time.LocalDateTime;

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
@Table(name="otp_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OtpDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
    @Column(nullable = false, unique = true,name="mobile")
	private String mobile;

    @Column(nullable = false, unique = true,name="otp")
	private String otp;;

    @Column(nullable = false, unique = true,name="expiry_time")
	private LocalDateTime expiryTime;

}
