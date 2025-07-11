package com.rapidshine.carwash.notification_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OtpEmailRequest {
    private String email;
    private String otp;
}
