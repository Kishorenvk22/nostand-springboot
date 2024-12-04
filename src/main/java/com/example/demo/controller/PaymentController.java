package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.service.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/payment")
public class PaymentController {

	
	@Autowired
	private PaymentService Paymentservice;
	
	@PostMapping("/create")
	public String createOrder(@RequestParam double amount) {

		try {
			return Paymentservice.createOrder(amount);
		}
		catch (Exception e) {
			return e.getMessage(); 
		}
		
	}
	//hi
}
