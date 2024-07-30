package com.nsbm.ems.notificationservice.service;

import com.nsbm.ems.notificationservice.model.Notification;
import com.nsbm.ems.notificationservice.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public String saveNotification(Notification notification) {
        notificationRepository.save(notification);
        return "Notification saved Successfully";
    }

    public String deleteNotification(Long nId) {
        notificationRepository.deleteById(nId);
        return "Notification deleted Successfully";
    }

    public List<Notification> getAllNotifications() {

        return notificationRepository.findAll();
    }

    public Notification getNotificationById(Long nId) {

        return notificationRepository.findById(nId).get();
    }

}

