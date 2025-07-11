package com.rapidshine.carwash.notification_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BookingCreatedEvent {
    private String email;
    private String bookingId;



}
