package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Configuration
@ConfigurationProperties(prefix="twilio")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TwilioConfig {
	
	
	
	
	@Override
	public String toString() {
		return "TwilioConfig [accountSid=" + accountSid + ", authToken=" + authToken + ", phonenumber=" + phonenumber
				+ "]";
	}
	private String accountSid;
	private String authToken;
	private String phonenumber;
	

}
