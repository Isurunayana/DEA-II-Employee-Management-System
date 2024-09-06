package com.nsbm.ems.attendenceservice.controller; *add doc and comment
*attendanve save and get update or delete

import com.nsbm.ems.attendenceservice.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping("/record")
    public String recordAttendance(@RequestParam String employeeId) {
        attendanceService.recordAttendance(employeeId);
        return "Attendance recorded for employee ID: " + employeeId;
    }
}
* get the constant file