package com.nsbm.ems.notificationservice.controller;

import com.nsbm.ems.notificationservice.model.Sallery;
import com.nsbm.ems.notificationservice.service.implementation.SalleryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/sallery")
public class SalleryConroller {

    @Autowired
    private SalleryServiceImpl salleryService;

    @PostMapping("/save")
    public String saveSalNotification(@RequestBody Sallery sallery) {

        salleryService.saveSalNotification(sallery);
        return "Successfully saved sallery";
    }

    @DeleteMapping("/{sId}")
    public String deleteSalNotification(@PathVariable Long sId) {

        return salleryService.deleteSalNotification(sId);
    }

    @GetMapping("/viewAll")
    public ResponseEntity<?> viewAllSalNotifications() {

        return salleryService.getAllSalNotifications();
    }

    @GetMapping("/{sId}")
    public ResponseEntity<?> viewSalNotification(@PathVariable Long sId) {

        return salleryService.getSalNotificationById(sId);
    }

    @PutMapping("/update")
    public String updateSalNotification(@RequestParam Long sId, @RequestBody Sallery sallery) {

        return salleryService.updateSalNotification(sId,sallery);
    }
}
