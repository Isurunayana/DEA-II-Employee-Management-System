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

    // Injecting NotificationRepository dependency
    @Autowired
    private NotificationRepository notificationRepository;

    // Method to save a notification
    @Override
    public String saveNotification(Notification notification) {
        try {
            // Save the notification using the repository
            notificationRepository.save(notification);
            return "Notification saved Successfully";
        } catch (Exception e) {
            // Handle and return any exception message
            return e.getMessage();
        }
    }

    // Method to delete a notification by its ID
    @Override
    public String deleteNotification(Long nId) {
        try {
            // Check if the notification with given ID exists
            if (notificationRepository.findById(nId).isPresent()) {
                // Delete notification by ID if it exists
                notificationRepository.deleteById(nId);
                return "Notification deleted Successfully";
            } else {
                // Return message if notification is not found
                return "Notification Record Not Found for the ID";
            }
        } catch (Exception e) {
            // Handle and return any exception message
            return e.getMessage();
        }
    }

    // Method to update an existing notification by its ID
    @Override
    public String updateNotification(Long nId, Notification newNotification) {
        try {
            // Retrieve the existing notification by ID
            Optional<Notification> credentialOptional = notificationRepository.findById(nId);
            Notification notification = credentialOptional.get();

            // Update the notification fields with new values
            notification.setMsg(newNotification.getMsg());
            notification.setEmpNic(newNotification.getEmpNic());
            notification.setTimeStamp(newNotification.getTimeStamp());

            // Save the updated notification and return the message
            return notificationRepository.save(notification).getMsg();
        } catch (Exception e) {
            // Handle and return any exception message
            return e.getMessage();
        }
    }

    // Method to get all notifications
    @Override
    public ResponseEntity<?> getAllNotifications() {
        try {
            // Return all notifications as a response entity
            return ResponseEntity.ok(notificationRepository.findAll());
        } catch (Exception e) {
            // Handle and return any exception message in the response body
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Method to get a notification by its ID
    @Override
    public ResponseEntity<?> getNotificationById(Long nId) {
        try {
            // Return the notification found by ID as a response entity
            return ResponseEntity.ok(notificationRepository.findById(nId).get());
        } catch (Exception e) {
            // Handle and return any exception message in the response body
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
