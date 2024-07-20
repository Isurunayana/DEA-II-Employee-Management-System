package com.nsbm.ems.notificationservice.controller;

import com.nsbm.ems.notificationservice.model.Notification;
import com.nsbm.ems.notificationservice.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification")
public class NotificationConroller {

    @Autowired
    private NotificationService notificationService;

    public String saveNotification(@RequestBody Notification notification) {

        notificationService.saveNotification(notification);
        return "Successfully saved notification";
    }
}
