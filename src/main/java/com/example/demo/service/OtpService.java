package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.twilio.type.PhoneNumber;


import com.example.demo.TwilioConfig;
import com.example.demo.entity.OtpDetails;
import com.example.demo.entity.User;
import com.example.demo.respository.OtpRepository;
import com.example.demo.respository.UserRepository;
import com.twilio.Twilio;
//import com.twilio.rest.conversations.v1.conversation.Message;
import com.twilio.rest.api.v2010.account.Message;

@Service
public class OtpService {
	@Autowired
    private UserRepository userRepository;

    @Autowired
    private OtpRepository otpRepository;

    @Autowired
    private TwilioConfig twilioConfig;

    public String sendOtp(String mobile) {
        Twilio.init(twilioConfig.getAccountSid(), twilioConfig.getAuthToken());

        String otp = String.valueOf(new Random().nextInt(900000) + 100000); // Generate 6-digit OTP
        LocalDateTime expiryTime = LocalDateTime.now().plusMinutes(1); // OTP valid for 5 minutes

        OtpDetails otpDetails = otpRepository.findByMobile(mobile)
                .orElse(new OtpDetails());
        otpDetails.setMobile(mobile);;
        otpDetails.setOtp(otp);
        otpDetails.setExpiryTime(expiryTime);

        otpRepository.save(otpDetails);

        Message.creator(
                new com.twilio.type.PhoneNumber(mobile),
                new com.twilio.type.PhoneNumber(twilioConfig.getPhonenumber()),
                "Your OTP is " + otp + ". Valid for 1 minutes."
        ).create();

        return "OTP sent successfully!";
    }

    public String verifyOtp(String mobile, String otp, User user) {
        OtpDetails otpDetails = otpRepository.findByMobile(mobile)
                .orElseThrow(() -> new RuntimeException("No OTP sent to this mobile number."));

        if (otpDetails.getExpiryTime().isBefore(LocalDateTime.now())) {
            return "OTP has expired.";
        }

        if (!otpDetails.getOtp().equals(otp)) {
            return "Invalid OTP.";
        }

        otpRepository.delete(otpDetails);

        if (userRepository.findByMobile(mobile).isPresent()) {
            return "This mobile number is already registered.";
        }

        userRepository.save(user);
        return "User registered successfully.";
    }
    
}
