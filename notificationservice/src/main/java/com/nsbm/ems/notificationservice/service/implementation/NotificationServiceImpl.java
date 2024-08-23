package com.nsbm.ems.notificationservice.service.implementation;

import com.nsbm.ems.notificationservice.model.Notification;
import com.nsbm.ems.notificationservice.repository.NotificationRepository;
import com.nsbm.ems.notificationservice.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public String saveNotification(Notification notification) {
        try {
            notificationRepository.save(notification);
            return "Notification saved Successfully";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String deleteNotification(Long nId) {
        try {
            if(notificationRepository.findById(nId).isPresent())
            {
                notificationRepository.deleteById(nId);
                return "Notification deleted Successfully";
            }
            else
            {
                return "Notification Record Not Found for the ID";
            }
        }catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String updateNotification(Long nId, Notification newNotification) {

        try {
            Optional<Notification> credentialOptional = notificationRepository.findById(nId);
            Notification notification = credentialOptional.get();
            notification.setMsg(newNotification.getMsg());
            notification.setEmpNic(newNotification.getEmpNic());
            notification.setTimeStamp(newNotification.getTimeStamp());

            return notificationRepository.save(notification).getMsg();
        }catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public ResponseEntity<?> getAllNotifications() {

        try {
            return ResponseEntity.ok(notificationRepository.findAll());
        }catch (Exception e) {


                return ResponseEntity.badRequest().body(e.getMessage());

        }

    }

    @Override
    public ResponseEntity<?> getNotificationById(Long nId) {
        try {
            return ResponseEntity.ok(notificationRepository.findById(nId).get());
        }catch (Exception e) {


            return ResponseEntity.badRequest().body(e.getMessage());

        }

    }

}


