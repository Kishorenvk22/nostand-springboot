package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OtpDetails {
	
	private String otp;
	private long expirationTime;
	
	public boolean isExpired() {
        return System.currentTimeMillis() > expirationTime;
    }

}
