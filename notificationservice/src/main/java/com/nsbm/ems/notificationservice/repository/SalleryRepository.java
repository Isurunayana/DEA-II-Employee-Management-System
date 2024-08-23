package com.nsbm.ems.notificationservice.repository;

import com.nsbm.ems.notificationservice.model.Notification;
import com.nsbm.ems.notificationservice.model.Sallery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalleryRepository extends JpaRepository<Sallery, Long> {
}
