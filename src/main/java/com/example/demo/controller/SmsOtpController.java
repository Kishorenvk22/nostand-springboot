package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.OtpService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/otp")
public class SmsOtpController {
	

    @Autowired
    private OtpService userService;

    @PostMapping("/sendOtp")
    public ResponseEntity<String> sendOtp(@RequestParam String mobile) {
        String response = userService.sendOtp(mobile);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/verifyOtp")
    public ResponseEntity<String> verifyOtp(
            @RequestParam String mobile,
            @RequestParam String otp,
            @RequestBody User user
    ) {
        String response = userService.verifyOtp(mobile, otp, user);
        return ResponseEntity.ok(response);
    }
	
//	@Autowired
//	private final OtpService otpService;
//	
//	public SmsOtpController(OtpService otpService) {
//		this.otpService=otpService;
//	}
//	
//	@PostMapping("/sendOtp")
//	public String sendOtp(@RequestParam String phoneNumber) {
//		return otpService.sendOtp(phoneNumber);
//		
//	}
//	
//	@PostMapping("/verifyOtp")
//    public String verifyOtp(@RequestParam String phoneNumber, @RequestParam String otp) {
//        return otpService.validateOtp(phoneNumber, otp);
//    }
//	@PostMapping("/sendOtp")
//	public ResponseEntity<Map<String, String>> sendOtp(@RequestParam String phoneNumber) {
//	    String result = otpService.sendOtp(phoneNumber);
//	    Map<String, String> response = new HashMap<>();
//	    response.put("message", result);
//	    return ResponseEntity.ok(response);
//	}

}
