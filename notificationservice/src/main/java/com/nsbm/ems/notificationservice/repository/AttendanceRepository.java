package com.nsbm.ems.notificationservice.repository;

import com.nsbm.ems.notificationservice.model.Notification;
import com.nsbm.ems.notificationservice.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
}
