package com.rapidshine.carwash.notification_service.service;

import com.rapidshine.carwash.notification_service.dto.NotificationResponseDto;
import com.rapidshine.carwash.notification_service.model.Notification;
import com.rapidshine.carwash.notification_service.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;

    public void markAsRead(Long id){
        Notification notification = notificationRepository.findById(id).get();
        notification.setRead(true);
        notificationRepository.save(notification);

    }
    public List<NotificationResponseDto> getAllNotification(String email){
        List<Notification> notifications = notificationRepository.findByUserEmailOrderByCreatedAtDesc(email);
        List<NotificationResponseDto> ans = new ArrayList<>();
        for(Notification notification: notifications){
            ans.add(mapToDto(notification));
        }
        return ans;

    }

    private NotificationResponseDto mapToDto(Notification notification){
        return  new NotificationResponseDto(notification.getId(), notification.getMessage(), notification.getCreatedAt(),notification.isRead());
    }
}
