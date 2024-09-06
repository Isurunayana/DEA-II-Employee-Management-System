package com.nsbm.ems.attendenceservice.service;

import com.nsbm.ems.attendenceservice.model.Attendance;
import com.nsbm.ems.attendenceservice.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    public Attendance recordAttendance(String employeeId) {
        Attendance attendance = new Attendance();
        attendance.setEmployeeId(employeeId);
        attendance.setTimestamp(LocalDateTime.now());
        return attendanceRepository.save(attendance);
    }
}

add new package call impl and move attendance service impl, move the this code
custom expection "user not found"