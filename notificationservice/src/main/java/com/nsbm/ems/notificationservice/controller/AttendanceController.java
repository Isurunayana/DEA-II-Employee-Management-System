package com.nsbm.ems.notificationservice.controller;

import com.nsbm.ems.notificationservice.model.Attendance;
import com.nsbm.ems.notificationservice.service.implementation.AttendanceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for handling HTTP requests related to attendance notifications.
 */
@RestController
@RequestMapping("api/v1/attendance")
public class AttendanceController {

    // Injecting the AttendanceServiceImpl bean
    @Autowired
    private AttendanceServiceImpl attendanceService;

    /**
     * Endpoint to save a new attendance notification.
     *
     * @param attendance The Attendance object to be saved.
     * @return A success message indicating that the attendance notification has been saved.
     */
    @PostMapping("/save")
    public String saveAttendanceNotification(@RequestBody Attendance attendance) {
        // Delegate the save operation to the service layer
        attendanceService.saveAttendanceNotification(attendance);
        return "Successfully saved attendance";
    }

    /**
     * Endpoint to delete an attendance notification by its ID.
     *
     * @param aId The ID of the attendance notification to be deleted.
     * @return A message indicating the result of the delete operation.
     */
    @DeleteMapping("/{aId}")
    public String deleteAttendanceNotification(@PathVariable Long aId) {
        // Delegate the delete operation to the service layer and return the result
        return attendanceService.deleteAttendanceNotification(aId);
    }

    /**
     * Endpoint to retrieve all attendance notifications.
     *
     * @return A ResponseEntity containing a list of all attendance notifications.
     */
    @GetMapping("/viewAll")
    public ResponseEntity<?> viewAllAttendanceNotifications() {
        // Delegate the retrieval of all attendance notifications to the service layer
        return attendanceService.getAllAttendanceNotifications();
    }

    /**
     * Endpoint to retrieve a specific attendance notification by its ID.
     *
     * @param aId The ID of the attendance notification to be retrieved.
     * @return A ResponseEntity containing the attendance notification details.
     */
    @GetMapping("/{aId}")
    public ResponseEntity<?> viewAttendanceNotification(@PathVariable Long aId) {
        // Delegate the retrieval of an attendance notification by ID to the service layer
        return attendanceService.getAttendanceNotificationById(aId);
    }

    /**
     * Endpoint to update an existing attendance notification.
     *
     * @param aId The ID of the attendance notification to be updated.
     * @param attendance The updated attendance notification details.
     * @return A message indicating the result of the update operation.
     */
    @PutMapping("/update")
    public String updateAttendanceNotification(@RequestParam Long aId, @RequestBody Attendance attendance) {
        // Delegate the update operation to the service layer
        return attendanceService.updateAttendanceNotification(aId, attendance);
    }
}
