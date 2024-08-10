package com.nsbm.ems.notificationservice.controller;

import com.nsbm.ems.notificationservice.model.Notification;
import com.nsbm.ems.notificationservice.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notification")
public class NotificationConroller {

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/save")
    public String saveNotification(@RequestBody Notification notification) {

        notificationService.saveNotification(notification);
        return "Successfully saved notification";
    }

    @DeleteMapping("/{nId}")
    public String deleteNotification(@PathVariable Long nId) {

        notificationService.deleteNotification(nId);
        return "Successfully deleted notification";
    }

    @GetMapping("/viewAll")
    public List<Notification> viewAllNotifications() {

        return notificationService.getAllNotifications();
    }

    @GetMapping("/{nId}")
    public Notification viewNotification(@PathVariable Long nId) {

        return notificationService.getNotificationById(nId);
    }

    @PutMapping("/update")
    public String updateNotification(@RequestParam Long nId, @RequestBody Notification notification) {

        return notificationService.updateNotification(nId,notification);
    }
}
