package com.nsbm.ems.notificationservice.service.implementation;

import com.nsbm.ems.notificationservice.model.Sallery;
import com.nsbm.ems.notificationservice.repository.SalleryRepository;
import com.nsbm.ems.notificationservice.service.SalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalleryServiceImpl implements SalleryService {

    // Injecting SalleryRepository dependency
    @Autowired
    private SalleryRepository salleryRepository;

    // Method to save a salary notification
    @Override
    public String saveSalNotification(Sallery sallery) {
        try {
            // Save the salary notification using the repository
            salleryRepository.save(sallery);
            return "Sallery saved Successfully";
        } catch (Exception e) {
            // Return a generic error message if something goes wrong
            return "Something went wrong";
        }
    }

    // Method to delete a salary notification by its ID
    @Override
    public String deleteSalNotification(Long sId) {
        try {
            // Check if the salary notification exists for the given ID
            if (salleryRepository.findById(sId).isPresent()) {
                // Delete the salary notification by ID
                salleryRepository.deleteById(sId);
                return "Sallery deleted Successfully";
            } else {
                // Return a message if the record does not exist
                return "Record doesn't exist for this ID";
            }
        } catch (Exception e) {
            // Handle and return any exception message
            return e.getMessage();
        }
    }

    // Method to update an existing salary notification by its ID
    @Override
    public String updateSalNotification(Long sId, Sallery sallery) {
        try {
            // Retrieve the existing salary notification by ID
            Optional<Sallery> credentialOptional = salleryRepository.findById(sId);
            Sallery sallery1 = credentialOptional.get();

            // Update the salary notification fields with new values
            sallery1.setMsg(sallery.getMsg());
            sallery1.setEmpNic(sallery.getEmpNic());
            sallery1.setTimeStamp(sallery.getTimeStamp());
            sallery1.setVal(sallery.getVal());

            // Save the updated salary notification and return the message
            return salleryRepository.save(sallery1).getMsg();
        } catch (Exception e) {
            // Handle and return any exception message
            return e.getMessage();
        }
    }

    // Method to get all salary notifications
    @Override
    public ResponseEntity<?> getAllSalNotifications() {
        try {
            // Return all salary notifications as a response entity
            return ResponseEntity.ok(salleryRepository.findAll());
        } catch (Exception e) {
            // Return a generic error message if something goes wrong
            return ResponseEntity.badRequest().body("Something went wrong");
        }
    }

    // Method to get a salary notification by its ID
    @Override
    public ResponseEntity<?> getSalNotificationById(Long sId) {
        try {
            // Return the salary notification found by ID as a response entity
            return ResponseEntity.ok(salleryRepository.findById(sId).get());
        } catch (Exception e) {
            // Handle and return any exception message
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}



