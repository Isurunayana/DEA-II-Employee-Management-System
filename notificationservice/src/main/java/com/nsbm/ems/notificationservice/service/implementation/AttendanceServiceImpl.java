package com.nsbm.ems.notificationservice.service.implementation;

import com.nsbm.ems.notificationservice.model.Attendance;
import com.nsbm.ems.notificationservice.repository.AttendanceRepository;
import com.nsbm.ems.notificationservice.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    // Injecting AttendanceRepository dependency
    @Autowired
    private AttendanceRepository attendanceRepository;

    // Method to save an attendance notification
    @Override
    public String saveAttendanceNotification(Attendance attendance) {
        try {
            // Save the attendance notification using the repository
            attendanceRepository.save(attendance);
            return "Attendance saved successfully";
        } catch (Exception e) {
            // Return a generic error message if something goes wrong
            return "Something went wrong";
        }
    }

    // Method to delete an attendance notification by its ID
    @Override
    public String deleteAttendanceNotification(Long aId) {
        try {
            // Check if the attendance notification exists for the given ID
            Optional<Attendance> attendanceOptional = attendanceRepository.findById(aId);
            if (attendanceOptional.isPresent()) {
                // Delete the attendance notification by ID
                attendanceRepository.deleteById(aId);
                return "Attendance deleted successfully";
            } else {
                // Return a message if the record does not exist
                return "Record doesn't exist for this ID";
            }
        } catch (Exception e) {
            // Handle and return any exception message
            return e.getMessage();
        }
    }

    // Method to update an existing attendance notification by its ID
    @Override
    public String updateAttendanceNotification(Long aId, Attendance attendance) {
        try {
            // Retrieve the existing attendance notification by ID
            Optional<Attendance> attendanceOptional = attendanceRepository.findById(aId);
            if (attendanceOptional.isPresent()) {
                Attendance existingAttendance = attendanceOptional.get();

                // Update the attendance notification fields with new values
                existingAttendance.setMsg(attendance.getMsg());
                existingAttendance.setEmpNic(attendance.getEmpNic());
                existingAttendance.setTimeStamp(attendance.getTimeStamp());

                // Save the updated attendance notification and return the message
                return attendanceRepository.save(existingAttendance).getMsg();
            } else {
                return "Record not found for this ID";
            }
        } catch (Exception e) {
            // Handle and return any exception message
            return e.getMessage();
        }
    }

    // Method to get all attendance notifications
    @Override
    public ResponseEntity<?> getAllAttendanceNotifications() {
        try {
            // Return all attendance notifications as a response entity
            return ResponseEntity.ok(attendanceRepository.findAll());
        } catch (Exception e) {
            // Return a generic error message if something goes wrong
            return ResponseEntity.badRequest().body("Something went wrong");
        }
    }

    // Method to get an attendance notification by its ID
    @Override
    public ResponseEntity<?> getAttendanceNotificationById(Long aId) {
        try {
            // Return the attendance notification found by ID as a response entity
            Optional<Attendance> attendanceOptional = attendanceRepository.findById(aId);
            if (attendanceOptional.isPresent()) {
                return ResponseEntity.ok(attendanceOptional.get());
            } else {
                return ResponseEntity.badRequest().body("Record not found");
            }
        } catch (Exception e) {
            // Handle and return any exception message
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
