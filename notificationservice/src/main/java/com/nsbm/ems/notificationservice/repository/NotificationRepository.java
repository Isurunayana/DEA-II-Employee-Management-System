package com.nsbm.ems.notificationservice.repository;

import com.nsbm.ems.notificationservice.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
