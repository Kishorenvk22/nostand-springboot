package com.example.demo.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;

@Service
public class PaymentService {
	
	@Value("${razorpay.key}")
	private String payKey;

	@Value("${razorpay.secret}")
	private String paySecret;
	
	public String createOrder(double amount) throws Exception{
		
		RazorpayClient razorpayClient= new RazorpayClient(payKey, paySecret);
		
		 
		JSONObject orderRequest= new JSONObject();
		
		orderRequest.put("amount", amount*100);
		orderRequest.put("currency", "INR");
		orderRequest.put("receipt", "txn_123456");
		orderRequest.put("payment_capture", 1);
		 Order order= razorpayClient.orders.create(orderRequest);
		 return order.toString();
	}
}
