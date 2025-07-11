package com.rapidshine.carwash.notification_service.messaging.rabbitmq;

import com.rapidshine.carwash.notification_service.dto.NotificationRequestDto;
import com.rapidshine.carwash.notification_service.model.Notification;
import com.rapidshine.carwash.notification_service.repository.NotificationRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificationRequestConsumer {
    @Autowired
    private NotificationRepository notificationRepository;

    @RabbitListener(queues = "notification.request.queue")
    public void notificationRequest(NotificationRequestDto notificationRequestDto){
        Notification notification = new Notification();
        notification.setCreatedAt(LocalDateTime.now());
        notification.setRole(notificationRequestDto.getRole());
        notification.setMessage(notificationRequestDto.getMessage());
        notification.setUserEmail(notificationRequestDto.getEmail());
        notification.setRead(false);
        notificationRepository.save(notification);
        System.out.println("Notification db update request completed");

    }

}
