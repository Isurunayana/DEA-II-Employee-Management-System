package com.nsbm.ems.notificationservice.service;

import com.nsbm.ems.notificationservice.model.Sallery;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SalleryService {
    String saveSalNotification(Sallery sallery);

    String deleteSalNotification(Long sId);

    String updateSalNotification(Long sId, Sallery sallery);

    ResponseEntity<?> getAllSalNotifications();

    ResponseEntity<?> getSalNotificationById(Long sId);
}
