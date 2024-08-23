package com.nsbm.ems.notificationservice.controller;

import com.nsbm.ems.notificationservice.model.Notification;
import com.nsbm.ems.notificationservice.service.implementation.NotificationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/notification")
public class NotificationConroller {

    @Autowired
    private NotificationServiceImpl notificationService;

    @PostMapping("/save")
    public String saveNotification(@RequestBody Notification notification) {

        notificationService.saveNotification(notification);
        return "Successfully saved notification";
    }

    @DeleteMapping("/{nId}")
    public String deleteNotification(@PathVariable Long nId) {

        return notificationService.deleteNotification(nId);
    }

    @GetMapping("/viewAll")
    public ResponseEntity<?> viewAllNotifications() {

        return notificationService.getAllNotifications();
    }

    @GetMapping("/{nId}")
    public ResponseEntity<?> viewNotification(@PathVariable Long nId) {

        return notificationService.getNotificationById(nId);
    }

    @PutMapping("/update")
    public String updateNotification(@RequestParam Long nId, @RequestBody Notification notification) {

        return notificationService.updateNotification(nId,notification);
    }
}
