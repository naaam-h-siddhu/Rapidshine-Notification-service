package com.rapidshine.carwash.notification_service.controller;

import com.netflix.discovery.converters.Auto;
import com.rapidshine.carwash.notification_service.dto.EmailRequest;
import com.rapidshine.carwash.notification_service.dto.OtpEmailRequest;
import com.rapidshine.carwash.notification_service.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")

public class EmailController {
    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest emailRequest){
        emailService.sendSimpleEmail(emailRequest.getEmail(),emailRequest.getSubject(),emailRequest.getBody());
        return ResponseEntity.ok("email sen successfully");
    }

    @PostMapping("/send-otp")
    public ResponseEntity<String> sendHtmlEmail(@RequestBody OtpEmailRequest otpEmailRequest){
        emailService.sendOtpEmail(otpEmailRequest.getEmail(),otpEmailRequest.getOtp());
        return ResponseEntity.ok("OTP email sent successfully");
    }

}
