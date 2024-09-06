package com.nsbm.ems.notificationservice.controller;

import com.nsbm.ems.notificationservice.model.Sallery;
import com.nsbm.ems.notificationservice.service.implementation.SalleryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for handling HTTP requests related to salary notifications.
 */
@RestController
@RequestMapping("api/v1/sallery")
public class SalleryConroller {

    // Injecting the SalleryServiceImpl bean
    @Autowired
    private SalleryServiceImpl salleryService;

    /**
     * Endpoint to save a new salary notification.
     *
     * @param sallery The Sallery object to be saved.
     * @return A success message indicating that the salary notification has been saved.
     */
    @PostMapping("/save")
    public String saveSalNotification(@RequestBody Sallery sallery) {
        // Delegate the save operation to the service layer
        salleryService.saveSalNotification(sallery);
        return "Successfully saved sallery";
    }

    /**
     * Endpoint to delete a salary notification by its ID.
     *
     * @param sId The ID of the salary notification to be deleted.
     * @return A message indicating the result of the delete operation.
     */
    @DeleteMapping("/{sId}")
    public String deleteSalNotification(@PathVariable Long sId) {
        // Delegate the delete operation to the service layer and return the result
        return salleryService.deleteSalNotification(sId);
    }

    /**
     * Endpoint to retrieve all salary notifications.
     *
     * @return A ResponseEntity containing a list of all salary notifications.
     */
    @GetMapping("/viewAll")
    public ResponseEntity<?> viewAllSalNotifications() {
        // Delegate the retrieval of all salary notifications to the service layer
        return salleryService.getAllSalNotifications();
    }

    /**
     * Endpoint to retrieve a specific salary notification by its ID.
     *
     * @param sId The ID of the salary notification to be retrieved.
     * @return A ResponseEntity containing the salary notification details.
     */
    @GetMapping("/{sId}")
    public ResponseEntity<?> viewSalNotification(@PathVariable Long sId) {
        // Delegate the retrieval of a salary notification by ID to the service layer
        return salleryService.getSalNotificationById(sId);
    }

    /**
     * Endpoint to update an existing salary notification.
     *
     * @param sId The ID of the salary notification to be updated.
     * @param sallery The updated salary notification details.
     * @return A message indicating the result of the update operation.
     */
    @PutMapping("/update")
    public String updateSalNotification(@RequestParam Long sId, @RequestBody Sallery sallery) {
        // Delegate the update operation to the service layer
        return salleryService.updateSalNotification(sId, sallery);
    }
}
