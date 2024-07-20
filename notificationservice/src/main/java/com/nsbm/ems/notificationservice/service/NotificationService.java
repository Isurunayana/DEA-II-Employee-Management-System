package com.nsbm.ems.notificationservice.service;

import com.nsbm.ems.notificationservice.model.Notification;
import com.nsbm.ems.notificationservice.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public String saveNotification(Notification notification) {
        notificationRepository.save(notification);
        return "Notification saved Successfully";
    }

}

