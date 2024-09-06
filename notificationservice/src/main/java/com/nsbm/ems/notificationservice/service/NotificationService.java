package com.nsbm.ems.notificationservice.service;

import com.nsbm.ems.notificationservice.model.Notification;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface NotificationService {
    String saveNotification(Notification notification);

    String deleteNotification(Long nId);

    String updateNotification(Long nId, Notification newNotification);

    ResponseEntity<?> getAllNotifications();

    ResponseEntity<?> getNotificationById(Long nId);
}
