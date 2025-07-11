package com.rapidshine.carwash.notification_service.repository;

import com.rapidshine.carwash.notification_service.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NotificationRepository  extends JpaRepository<Notification,Long> {
    @Query("SELECT n FROM Notification n WHERE n.userEmail = :email ORDER BY n.createdAt DESC")
    List<Notification> findByUserEmailOrderByCreatedAtDesc(@Param("email") String email);

}
