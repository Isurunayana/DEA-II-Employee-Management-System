package com.nsbm.ems.notificationservice.service;

import com.nsbm.ems.notificationservice.model.Attendance;
import org.springframework.http.ResponseEntity;

public interface AttendanceService {
    // Method to save an attendance notification
    String saveAttendanceNotification(Attendance attendance);

    // Method to delete an attendance notification by its ID
    String deleteAttendanceNotification(Long aId);

    // Method to update an attendance notification by its ID
    String updateAttendanceNotification(Long aId, Attendance attendance);

    // Method to get all attendance notifications
    ResponseEntity<?> getAllAttendanceNotifications();

    // Method to get a specific attendance notification by its ID
    ResponseEntity<?> getAttendanceNotificationById(Long aId);
}
