package com.nsbm.ems.notificationservice.service;

import com.nsbm.ems.notificationservice.model.Notification;
import com.nsbm.ems.notificationservice.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public String saveNotification(Notification notification) {
        try {
            notificationRepository.save(notification);
            return "Notification saved Successfully";
        } catch (Exception e) {
            return "Something went wrong";
        }
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

    public String updateNotification(Long nId,Notification newNotification) {

        Optional<Notification> credentialOptional = notificationRepository.findById(nId);
        Notification notification = credentialOptional.get();
        notification.setMsg(newNotification.getMsg());
        notification.setEmpNic(newNotification.getEmpNic());
        notification.setTimeStamp(newNotification.getTimeStamp());

        return notificationRepository.save(notification).getMsg();
    }

}


