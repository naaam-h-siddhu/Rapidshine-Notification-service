package com.rapidshine.carwash.notification_service.service.scheduler;

import com.rapidshine.carwash.notification_service.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationDBCleanupJob {
    private final NotificationRepository notificationRepository;

}
