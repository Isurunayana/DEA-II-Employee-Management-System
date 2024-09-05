package com.nsbm.ems.notificationservice.controller;

import com.nsbm.ems.notificationservice.model.Notification;
import com.nsbm.ems.notificationservice.service.implementation.NotificationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for handling HTTP requests related to notifications.
 */
@RestController
@RequestMapping("api/v1/notification")
public class NotificationConroller {

    // Injecting the NotificationServiceImpl bean
    @Autowired
    private NotificationServiceImpl notificationService;

    /**
     * Endpoint to save a new notification.
     *
     * @param notification The notification object to be saved.
     * @return A success message indicating that the notification has been saved.
     */
    @PostMapping("/save")
    public String saveNotification(@RequestBody Notification notification) {
        // Delegate the save operation to the service layer
        notificationService.saveNotification(notification);
        return "Successfully saved notification";
    }

    /**
     * Endpoint to delete a notification by its ID.
     *
     * @param nId The ID of the notification to be deleted.
     * @return A message indicating the result of the delete operation.
     */
    @DeleteMapping("/{nId}")
    public String deleteNotification(@PathVariable Long nId) {
        // Delegate the delete operation to the service layer and return the result
        return notificationService.deleteNotification(nId);
    }

    /**
     * Endpoint to retrieve all notifications.
     *
     * @return A ResponseEntity containing a list of all notifications.
     */
    @GetMapping("/viewAll")
    public ResponseEntity<?> viewAllNotifications() {
        // Delegate the retrieval of all notifications to the service layer
        return notificationService.getAllNotifications();
    }

    /**
     * Endpoint to retrieve a specific notification by its ID.
     *
     * @param nId The ID of the notification to be retrieved.
     * @return A ResponseEntity containing the notification details.
     */
    @GetMapping("/{nId}")
    public ResponseEntity<?> viewNotification(@PathVariable Long nId) {
        // Delegate the retrieval of a notification by ID to the service layer
        return notificationService.getNotificationById(nId);
    }

    /**
     * Endpoint to update an existing notification.
     *
     * @param nId The ID of the notification to be updated.
     * @param notification The updated notification details.
     * @return A message indicating the result of the update operation.
     */
    @PutMapping("/update")
    public String updateNotification(@RequestParam Long nId, @RequestBody Notification notification) {
        // Delegate the update operation to the service layer
        return notificationService.updateNotification(nId, notification);
    }
}
