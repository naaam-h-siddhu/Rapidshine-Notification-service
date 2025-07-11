package com.rapidshine.carwash.notification_service.controller;

import com.rapidshine.carwash.notification_service.dto.NotificationResponseDto;
import com.rapidshine.carwash.notification_service.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/get-all-notification")
    public ResponseEntity<List<NotificationResponseDto>> getAllNotificaiton(Authentication authentication){
        String email = authentication.getName();
        return ResponseEntity.ok(notificationService.getAllNotification(email));
    }

    @PutMapping("/mark-done/{id}")
    public void markNotificationAsDone(Authentication authentication, @PathVariable Long id) {
        notificationService.markAsRead(id);
    }
}
